package br.com.curso.application.usecaseimpl;

import br.com.curso.application.geteway.CreateTransactionPinGetway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.usecase.CreateTransactionPinUseCase;

public class CreateTransactionPinUseCaseImpl implements CreateTransactionPinUseCase {
    private CreateTransactionPinGetway createTransactionPinGetway;

    public CreateTransactionPinUseCaseImpl(CreateTransactionPinGetway createTransactionPinGetway) {
        this.createTransactionPinGetway = createTransactionPinGetway;
    }

    @Override
    public void create(TransactionPin TransactionPin) {
        createTransactionPinGetway.create(TransactionPin);
    }
}
