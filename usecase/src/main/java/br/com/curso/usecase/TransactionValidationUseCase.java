package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;

public interface TransactionValidationUseCase{

    Boolean validate(Transaction transaction);

}
