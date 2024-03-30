package br.com.curso.usecase;

import br.com.curso.core.domain.User;

public interface FindUserByTaxNumberUseCase {
    User findByTaxNumber(String taxNumber);
}
