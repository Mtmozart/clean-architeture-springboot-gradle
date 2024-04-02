package br.com.curso.application.geteway;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.domain.User;
import br.com.curso.core.domain.Wallet;

public interface CreateUserGeteway {

    Boolean create(User user, Wallet wallet);
}
