package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;

import java.math.BigDecimal;

public interface TransferUserCase {
    Boolean transfer(String from , String toTaxNumber, BigDecimal value);
}
