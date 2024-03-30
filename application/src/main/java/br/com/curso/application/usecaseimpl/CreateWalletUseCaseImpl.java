package br.com.curso.application.usecaseimpl;

import br.com.curso.application.geteway.CreateUserGeteway;
import br.com.curso.application.geteway.CreateWalletGeteway;
import br.com.curso.core.domain.Wallet;
import br.com.curso.usecase.CreateWalletUseCase;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {
    private CreateWalletGeteway createWalletGeteway;

    public CreateWalletUseCaseImpl(CreateWalletGeteway createWalletGeteway) {
        this.createWalletGeteway = createWalletGeteway;
    }

    @Override
    public void create(Wallet wallet) {
        createWalletGeteway.create(wallet);
    }
}
