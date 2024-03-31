package br.com.curso.application.geteway;

import br.com.curso.core.domain.Wallet;

public interface FindWalletByTaxNumberGeteway {

    Wallet findByTaxNumber(String taxNumber);
}
