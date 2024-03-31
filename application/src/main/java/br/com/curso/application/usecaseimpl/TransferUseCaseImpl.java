package br.com.curso.application.usecaseimpl;

import br.com.curso.application.geteway.TransferGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.InternalServerErrorException;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.CreateTransactionUserCase;
import br.com.curso.usecase.FindWalletByTaxNumberUseCase;
import br.com.curso.usecase.TransactionValidationUseCase;
import br.com.curso.usecase.TransferUserCase;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUserCase {

    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private TransactionValidationUseCase transactionValidationUseCase;
    private CreateTransactionUserCase createTransactionUserCase;

    private TransferGateway transferGateway;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidationUseCase transactionValidationUseCase, CreateTransactionUserCase createTransactionUserCase, TransferGateway transferGateway) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidationUseCase = transactionValidationUseCase;
        this.createTransactionUserCase = createTransactionUserCase;
        this.transferGateway = transferGateway;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException {
        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);
        from.transfer(value);
        to.receiveTransfer(value);
        var transaction = createTransactionUserCase.create(new Transaction(from, to, value));

        transactionValidationUseCase.validate(transaction);

        if (!transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }


        return true;
    }
}
