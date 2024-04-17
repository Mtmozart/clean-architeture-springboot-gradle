package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.TransactionValidationGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.infrastructure.client.apivalidate.response.ApiValidateService;
import org.springframework.stereotype.Service;
import static br.com.curso.infrastructure.utils.Utilities.log;

@Service
public class TransactionValidationGatewayImpl implements TransactionValidationGateway {

    private ApiValidateService apiValidateService;

    public TransactionValidationGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }

    @Override
    public Boolean validate(Transaction transaction) {
        log.info("Inicio da validação da transação por serviço externo::TransactionValidateGatewayImpl");
        var response = apiValidateService.validate();
        if (response == null) {
            log.info("Transação rejeitada::TransactionValidateGatewayImpl");
            return false;
        }
        log.info("Transação aprovada::TransactionValidateGatewayImpl");
        return apiValidateService.validate().success();
    }
}
