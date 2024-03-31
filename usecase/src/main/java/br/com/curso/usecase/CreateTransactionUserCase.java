package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;

public interface CreateTransactionUserCase {
    public Transaction create(Transaction transaction);
}
