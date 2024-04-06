package br.com.curso.application.gateway;

import br.com.curso.core.domain.TransactionPin;

public interface TransactionPinValidationGateway {
    boolean validate(TransactionPin transactionPin);
}
