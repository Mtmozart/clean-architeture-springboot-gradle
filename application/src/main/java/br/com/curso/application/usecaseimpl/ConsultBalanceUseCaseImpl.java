package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.ConsultBalanceGateway;
import br.com.curso.core.domain.Wallet;
import br.com.curso.usecase.ConsultBalanceUseCase;
import br.com.curso.usecase.FindWalletByTaxNumberUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {
    private ConsultBalanceGateway consultBalanceGateway;

    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;

    public ConsultBalanceUseCaseImpl(ConsultBalanceGateway consultBalanceGateway, FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        this.consultBalanceGateway = consultBalanceGateway;
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
    }


    @Override
    public BigDecimal consult(Wallet wallet) {
        var wallet = findWalletByTaxNumberUseCase.findByTaxNumber(taxNumber);
        return consultBalanceGateway.consult(wallet);
        return null;
    }
}
