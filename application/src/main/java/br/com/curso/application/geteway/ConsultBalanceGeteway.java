package br.com.curso.application.geteway;

import br.com.curso.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGeteway {

    BigDecimal consult(Wallet wallet);
}
