package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.TransactionPinValidationGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.exception.BadRequestException;
import br.com.curso.core.exception.PinException;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.TransactionPinValidationUseCase;
import br.com.curso.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidationUseCaseImpl implements TransactionPinValidationUseCase {
    private TransactionPinValidationGateway transactionPinValidationGateway;
    private UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidationUseCaseImpl(TransactionPinValidationGateway transactionPinValidationGateway, UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.transactionPinValidationGateway = transactionPinValidationGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin, String pin) throws TransferException, PinException, BadRequestException {
        if (transactionPin.getBlocker()) throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());

        if (!transactionPinValidationGateway.validate(transactionPin, pin)){
            transactionPin.setAttempt();
            var transactionPinUpdated = updateTransactionPinUseCase.update(transactionPin);
            throw new PinException(ErrorCodeEnum.pin0001GetMessage(transactionPinUpdated.getAttempt()), ErrorCodeEnum.PIN0002.getCode());
        }

        if (transactionPin.getAttempt() < 3){
            transactionPin.restaureAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }

        return true;
    }
}
