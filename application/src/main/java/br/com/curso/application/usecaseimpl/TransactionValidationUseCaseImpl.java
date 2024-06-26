package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.TransactionValidationGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.TransactionValidationUseCase;

public class TransactionValidationUseCaseImpl implements TransactionValidationUseCase {
    private TransactionValidationGateway transactionValidationGateway;


    public TransactionValidationUseCaseImpl(TransactionValidationGateway transactionValidationGateway) {
        this.transactionValidationGateway = transactionValidationGateway;
    }

    @Override
    public Boolean validate(Transaction transaction) throws TransferException {
        if(!transactionValidationGateway.validate(transaction)){
            throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }

        return true;
    }
}
