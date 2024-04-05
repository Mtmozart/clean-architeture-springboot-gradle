package br.com.curso.application.gateway;

import br.com.curso.core.domain.Transaction;

public interface UserNotificationGeteway {
       Boolean notificate(Transaction transaction, String email);
}
