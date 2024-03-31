package br.com.curso.application.usecaseimpl;

import br.com.curso.application.geteway.FindWalletByTaxNumberGeteway;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.NotFoundException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {
    private FindWalletByTaxNumberGeteway findWalletByTaxNumberGeteway;
    @Override
    public Wallet findByTaxNumber(String taxNumber) throws NotFoundException {
        var wallet =findWalletByTaxNumberGeteway.findByTaxNumber(taxNumber);
        if(wallet == null){
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }
        return wallet;
    }
}
