package br.com.curso.application.usecaseimpl;

import br.com.curso.application.geteway.TaxNumberAvailableGeteway;
import br.com.curso.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {

    private TaxNumberAvailableGeteway taxNumberAvailableGeteway;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGeteway taxNumberAvailableGeteway) {
        this.taxNumberAvailableGeteway = taxNumberAvailableGeteway;
    }
    @Override
    public Boolean taxNumberAvaliable(String taxNumber) {
        return taxNumberAvailableGeteway.taxNumberAvailable(taxNumber);
    }
}
