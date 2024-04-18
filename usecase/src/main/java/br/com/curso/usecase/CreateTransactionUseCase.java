package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;

import java.math.BigDecimal;

public interface CreateTransactionUseCase {
    public Transaction create(Wallet to, Wallet from, BigDecimal value) throws Exception;
}
