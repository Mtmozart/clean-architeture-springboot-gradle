package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.TransferGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.User;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.*;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private TransactionValidationUseCase transactionValidationUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private TransferGateway transferGateway;
    private UserNotificationUseCase userNotificationUseCase;
    private TransactionPinValidationUseCase transactionPinValidationUseCase;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidationUseCase transactionValidationUseCase, CreateTransactionUseCase createTransactionUseCase, TransferGateway transferGateway, UserNotificationUseCase userNotificationUseCase, TransactionPinValidationUseCase transactionPinValidationUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidationUseCase = transactionValidationUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transactionPinValidationUseCase = transactionPinValidationUseCase;
    }

    @Override
    public Boolean transfer(Transaction transaction) throws Exception {

        transaction.getFromWallet().transfer(transaction.getValue());
        transaction.getToWallet().receiveTransfer(transaction.getValue());

        transactionValidationUseCase.validate(transaction);

        if (!transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return true;
    }
}
