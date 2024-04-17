package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.TransactionPinValidationGateway;
import br.com.curso.core.domain.TransactionPin;
import static br.com.curso.infrastructure.utils.Utilities.log;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionPinValidationGatewayImpl implements TransactionPinValidationGateway {

    @Override
    public boolean validate(TransactionPin transactionPin, String pin) {
        log.info("Inicio da validação da senha de transação::TransactionPinValidationGatewayImpl");
        if (!Objects.equals(transactionPin.getPin(), pin)){
            log.info("Senha incorreta::TransactionPinValidationGatewayImpl");
            return false;
        }
        log.info("Senha correta::TransactionPinValidationGatewayImpl");
        return true;
    }
}
