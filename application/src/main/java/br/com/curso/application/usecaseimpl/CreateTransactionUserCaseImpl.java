package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.CreateTransactionGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.CreateTransactionUserCase;

public class CreateTransactionUserCaseImpl implements CreateTransactionUserCase {
    private CreateTransactionGateway createTransactionGateway;
    @Override
    public Transaction create(Transaction transaction) throws TransferException {
       var transactionSaved = createTransactionGateway.create(transaction);
       if(transactionSaved == null){
           throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
       }
        return transactionSaved;
    }
}
