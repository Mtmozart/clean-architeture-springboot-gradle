package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.UserNotificationGeteway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.usecase.UserNotificationUseCase;

public class UserNotificationUseCaseImpl implements UserNotificationUseCase {
    private UserNotificationGeteway userNotificationGeteway;
    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return userNotificationGeteway.notificate(transaction, email);
    }
}
