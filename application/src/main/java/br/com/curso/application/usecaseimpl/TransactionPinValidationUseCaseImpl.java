package br.com.curso.application.usecaseimpl;

import br.com.curso.application.geteway.TransactionPinValidationGeteway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.exception.PinException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.TransactionPinValidationUseCase;
import br.com.curso.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidationUseCaseImpl implements TransactionPinValidationUseCase {
    private TransactionPinValidationGeteway transactionPinValidationGeteway;
    private UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidationUseCaseImpl(TransactionPinValidationGeteway transactionPinValidationGeteway, UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.transactionPinValidationGeteway = transactionPinValidationGeteway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) throws PinException {
        if(transactionPin.getBlocker()){
            throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());
        }
        if(!transactionPinValidationGeteway.validate(transactionPin)){
        transactionPin.setAttempt();
        var transactionPinUpdate = updateTransactionPinUseCase.update(transactionPin);
        throw new PinException(ErrorCodeEnum.pin0001GetMessage(transactionPinUpdate.getAttempt()), ErrorCodeEnum.PIN0002.getCode());
        }
        if (transactionPin.getAttempt() < 3) {
            transactionPin.restaureAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }
        return true;
    }
}
