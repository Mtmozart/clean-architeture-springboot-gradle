package br.com.curso.usecase;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.exception.BadRequestException;
import br.com.curso.core.exception.PinException;
import br.com.curso.core.exception.TransferException;

public interface TransactionPinValidationUseCase {
    Boolean validate(TransactionPin transactionPin, String pin) throws TransferException, PinException, BadRequestException;

}
