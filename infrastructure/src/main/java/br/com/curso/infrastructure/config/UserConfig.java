package br.com.curso.infrastructure.config;

import br.com.curso.application.geteway.CreateUserGeteway;
import br.com.curso.application.geteway.EmailAvailableGeteway;
import br.com.curso.application.geteway.TaxNumberAvailableGeteway;
import br.com.curso.application.usecaseimpl.CreateUserUseCaseImpl;
import br.com.curso.application.usecaseimpl.EmailAvailableUseCaseImpl;
import br.com.curso.application.usecaseimpl.TaxNumberAvailableUseCaseImpl;
import br.com.curso.usecase.CreateUserUseCase;
import br.com.curso.usecase.EmailAvailableUseCase;
import br.com.curso.usecase.TaxNumberAvailableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGeteway taxNumberAvailableGeteway){
        return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGeteway);
    }
    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGeteway emailAvailableGeteway){
        return new EmailAvailableUseCaseImpl(emailAvailableGeteway);
    }

    @Bean
    public CreateUserUseCase createUserUseCaseCase(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGeteway createUserGeteway){
        return new CreateUserUseCaseImpl(taxNumberAvailableUseCase, emailAvailableUseCase, createUserGeteway);
    }
}
