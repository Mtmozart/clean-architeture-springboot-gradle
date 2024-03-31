package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.InternalServerErrorException;
import br.com.curso.core.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUserCase {
    Boolean transfer(String from , String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException;
}
