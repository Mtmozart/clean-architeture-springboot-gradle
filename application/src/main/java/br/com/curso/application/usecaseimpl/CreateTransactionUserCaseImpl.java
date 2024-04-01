package br.com.curso.application.usecaseimpl;

import br.com.curso.application.geteway.CreateTransactionGeteway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.CreateTransactionUserCase;

public class CreateTransactionUserCaseImpl implements CreateTransactionUserCase {
    private CreateTransactionGeteway createTransactionGeteway;
    @Override
    public Transaction create(Transaction transaction) throws TransferException {
       var transactionSaved = createTransactionGeteway.create(transaction);
       if(transactionSaved == null){
           throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
       }
        return transactionSaved;
    }
}
