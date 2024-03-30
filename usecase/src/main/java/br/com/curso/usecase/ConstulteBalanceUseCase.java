package br.com.curso.usecase;

import br.com.curso.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConstulteBalanceUseCase {
    BigDecimal consulte(Wallet wallet);
}
