package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.EmailAvailableGeteway;
import br.com.curso.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailAvailableGetewayImpl implements EmailAvailableGeteway {
    private UserEntityRepository userEntityRepository;

    public EmailAvailableGetewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean emailAvailable(String email) {
        return !userEntityRepository.existsByEmail(email);
    }
}
