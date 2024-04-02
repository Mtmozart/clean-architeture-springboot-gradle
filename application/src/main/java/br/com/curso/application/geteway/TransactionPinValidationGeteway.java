package br.com.curso.application.geteway;

import br.com.curso.core.domain.TransactionPin;

public interface TransactionPinValidationGeteway {
    boolean validate(TransactionPin transactionPin);
}
