package br.com.curso.application.usecaseimpl;

import br.com.curso.core.domain.Wallet;
import br.com.curso.usecase.FindWalletByTaxNumberUseCase;
import br.com.curso.usecase.TransferUserCase;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUserCase {

    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;



    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) {
        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);
        return null;
    }
}
