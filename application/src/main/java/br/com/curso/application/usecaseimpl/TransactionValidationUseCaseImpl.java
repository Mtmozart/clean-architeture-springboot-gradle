package br.com.curso.application.usecaseimpl;

import br.com.curso.application.geteway.TransactionValidationGeteway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.InternalServerErrorException;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.TransactionValidationUseCase;

public class TransactionValidationUseCaseImpl implements TransactionValidationUseCase {
    private TransactionValidationGeteway transactionValidationGeteway;


    @Override
    public Boolean validate(Transaction transaction) throws TransferException {
        if(!transactionValidationGeteway.validate(transaction)){
            throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }

        return true;
    }
}