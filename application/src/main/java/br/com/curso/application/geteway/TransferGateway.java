package br.com.curso.application.geteway;

import br.com.curso.core.domain.Transaction;

public interface TransferGateway {
    Boolean transfer(Transaction transaction);
}
