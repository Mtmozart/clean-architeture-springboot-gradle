package br.com.curso.infrastructure.controller;

import br.com.curso.infrastructure.dto.response.BaseResponse;
import br.com.curso.infrastructure.dto.response.ConsultBalanceResponse;
import br.com.curso.usecase.ConsultBalanceUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {

    private ConsultBalanceUseCase consultBalanceUseCase;

    public WalletController(ConsultBalanceUseCase consultBalanceUseCase) {
        this.consultBalanceUseCase = consultBalanceUseCase;
    }

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws Exception {
        var balance = consultBalanceUseCase.consult(taxNumber);
        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
    }

}
