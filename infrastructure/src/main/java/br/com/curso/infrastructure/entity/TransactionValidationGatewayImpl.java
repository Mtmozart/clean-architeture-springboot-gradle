package br.com.curso.infrastructure.entity;

import br.com.curso.application.gateway.TransactionValidationGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.infrastructure.client.ApiValidateService;
import org.springframework.stereotype.Service;

@Service
public class TransactionValidationGatewayImpl implements TransactionValidationGateway {

    private ApiValidateService apiValidateService;

    public TransactionValidationGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }

    @Override
    public Boolean validate(Transaction transaction) {
        var response = apiValidateService.validate();
        if (response == null) {
            return false;
        }

        return apiValidateService.validate().success();
    }
}
