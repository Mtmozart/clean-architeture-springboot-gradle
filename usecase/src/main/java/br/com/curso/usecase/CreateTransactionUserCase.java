package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;

public interface CreateTransactionUserCase {
    public void create(Transaction transaction);
}
