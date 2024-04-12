package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;

public interface CreateTransactionUseCase {
    public Transaction create(Transaction transaction) throws Exception;
}
