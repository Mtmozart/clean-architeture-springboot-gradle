package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.ConsultBalanceGateway;
import br.com.curso.core.domain.Wallet;
import br.com.curso.usecase.ConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {
    private ConsultBalanceGateway consultBalanceGeteway;
    @Override
    public BigDecimal consult(Wallet wallet) {
        return consultBalanceGeteway.consult(wallet);
    }
}
