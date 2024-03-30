package br.com.curso.application.usecaseimpl;

import br.com.curso.application.geteway.EmailAvailableGeteway;
import br.com.curso.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {
    private EmailAvailableGeteway emailAvailableGeteway;

    public EmailAvailableUseCaseImpl(EmailAvailableGeteway emailAvailableGeteway) {
        this.emailAvailableGeteway = emailAvailableGeteway;
    }

    @Override
    public Boolean emailAvailable(String email) {
        return emailAvailableGeteway.emailAvailable(email);
    }
}
