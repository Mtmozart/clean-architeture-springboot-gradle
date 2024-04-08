package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.TransactionPinValidationGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.infrastructure.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionPinValidationGatewayImpl implements TransactionPinValidationGateway {

    private TransactionPinEntityRepository transactionPinEntityRepository;

    public TransactionPinValidationGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
    }

    @Override
    public boolean validate(TransactionPin transactionPin) {
        var transactionPinSaved = transactionPinEntityRepository.findById(transactionPin.getId());
        if (transactionPinSaved.isEmpty()){
            return false;
        }
        if (!Objects.equals(transactionPinSaved.get().getPin(), transactionPin.getPin())){
            return false;
        }
        return true;
    }
}
