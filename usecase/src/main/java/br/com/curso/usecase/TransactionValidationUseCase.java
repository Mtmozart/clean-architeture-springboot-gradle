package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.TransferException;

public interface TransactionValidationUseCase{
    Boolean validate(Transaction transaction) throws TransferException;

}
