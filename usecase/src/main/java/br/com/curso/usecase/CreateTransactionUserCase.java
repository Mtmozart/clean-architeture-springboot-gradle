package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.TransferException;

public interface CreateTransactionUserCase {
    public Transaction create(Transaction transaction) throws TransferException;
}
