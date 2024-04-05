package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.TaxNumberAvailableGeteway;
import br.com.curso.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import static br.com.curso.infrastructure.utils.Utilities.log;

@Service
public class TaxNumberAvailableGetewayImpl implements TaxNumberAvailableGeteway {
    private UserEntityRepository userEntityRepository;

    public TaxNumberAvailableGetewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        log.info("Iniciando verificação se o TaxNumber está disponível.");
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
