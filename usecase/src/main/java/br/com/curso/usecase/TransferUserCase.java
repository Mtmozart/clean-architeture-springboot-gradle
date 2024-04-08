package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.*;

import java.math.BigDecimal;

public interface TransferUserCase {
    Boolean transfer(String from , String toTaxNumber, BigDecimal value, String pin) throws Exception;
}
