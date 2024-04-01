package br.com.curso.application.geteway;

import br.com.curso.core.domain.Transaction;

public interface TransactionValidationGeteway {
    Boolean validate(Transaction transaction);
}
