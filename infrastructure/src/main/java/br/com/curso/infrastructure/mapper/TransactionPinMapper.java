package br.com.curso.infrastructure.mapper;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.infrastructure.entity.TransactionPinEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {
    public TransactionPinEntity toTransactionPinEntity(TransactionPin transactionPin){
        return new TransactionPinEntity(
                transactionPin.getPin(),
                transactionPin.getAttempt(),
                transactionPin.getBlocker(),
                transactionPin.getCreatedAt(),
                transactionPin.getUpdatedAt()
        );

    }

    public TransactionPin toTransactionPin(TransactionPinEntity transactionPinEntity){
        return new TransactionPin(
            transactionPinEntity.getId(),
                transactionPinEntity.getPin(),
                transactionPinEntity.getAttempt(),
                transactionPinEntity.getBlocked(),
                transactionPinEntity.getCreatedAt(),
                transactionPinEntity.getUpdatedAt()
        );

    }

    public TransactionPinEntity toTransactionPinEntityUpdate(TransactionPin transactionPin){
        return new TransactionPinEntity(
                transactionPin.getId(),
                transactionPin.getPin(),
                transactionPin.getAttempt(),
                transactionPin.getBlocker(),
                transactionPin.getCreatedAt(),
                transactionPin.getUpdatedAt()
        );
    }
}
