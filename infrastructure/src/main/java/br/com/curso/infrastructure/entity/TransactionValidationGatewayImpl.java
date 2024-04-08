package br.com.curso.infrastructure.entity;

import br.com.curso.application.gateway.TransactionValidationGateway;
import br.com.curso.core.domain.Transaction;

public class TransactionValidationGatewayImpl implements TransactionValidationGateway {
    @Override
    public Boolean validate(Transaction transaction) {
        return null;
    }
}
