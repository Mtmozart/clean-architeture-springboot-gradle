package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.CreateTransactionGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.CreateTransactionUseCase;

import java.math.BigDecimal;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {
    private CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Wallet to, Wallet from, BigDecimal value) throws Exception {
        var transaction = new Transaction(to, from, value);
        var transactionSaved = createTransactionGateway.create(transaction);

        if (transactionSaved == null){
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return  transactionSaved;
    }
}