package br.com.curso.infrastructure.controller;

import br.com.curso.infrastructure.dto.request.TransferRequest;
import br.com.curso.infrastructure.dto.response.BaseResponse;
import br.com.curso.infrastructure.dto.response.ConsultBalanceResponse;
import br.com.curso.usecase.ConsultBalanceUseCase;
import br.com.curso.usecase.TransferUserCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {

    private ConsultBalanceUseCase consultBalanceUseCase;
    private TransferUserCase transferUserCase;

    public WalletController(ConsultBalanceUseCase consultBalanceUseCase, TransferUserCase transferUserCase) {
        this.consultBalanceUseCase = consultBalanceUseCase;
        this.transferUserCase = transferUserCase;
    }

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws Exception {
        var balance = consultBalanceUseCase.consult(taxNumber);
        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transfer(@RequestBody TransferRequest transferRequest) throws Exception {
        transferUserCase.transfer(transferRequest.fromTaxNumber(), transferRequest.toTaxNumber(), transferRequest.value(), transferRequest.pin());
        return null;
    }

}
