package br.com.curso.infrastructure.config;

import br.com.curso.application.gateway.FindWalletByTaxNumberGateway;
import br.com.curso.application.usecaseimpl.ConsultBalanceUseCaseImpl;
import br.com.curso.application.usecaseimpl.FindWalletByTaxNumberUseCaseImpl;
import br.com.curso.usecase.ConsultBalanceUseCase;
import br.com.curso.usecase.FindWalletByTaxNumberUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletConfig {

    @Bean
    public FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        return new FindWalletByTaxNumberUseCaseImpl(findWalletByTaxNumberGateway);
    }
    @Bean
    public ConsultBalanceUseCase consultBalanceUseCase(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        return new ConsultBalanceUseCaseImpl(findWalletByTaxNumberUseCase);
    }


}
