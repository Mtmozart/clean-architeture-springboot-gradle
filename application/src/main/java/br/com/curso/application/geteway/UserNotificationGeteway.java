package br.com.curso.application.geteway;

import br.com.curso.core.domain.Transaction;

public interface UserNotificationGeteway {
       Boolean notificate(Transaction transaction, String email);
}
