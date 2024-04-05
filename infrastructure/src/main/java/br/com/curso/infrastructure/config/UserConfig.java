package br.com.curso.infrastructure.config;


import br.com.curso.application.gateway.CreateUserGeteway;
import br.com.curso.application.gateway.EmailAvailableGeteway;
import br.com.curso.application.gateway.TaxNumberAvailableGeteway;
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
    public TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGeteway taxNumberAvailableGateway){
        return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGateway);
    }

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGeteway emailAvailableGateway){
        return new EmailAvailableUseCaseImpl(emailAvailableGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGeteway createUserGateway){
        return new CreateUserUseCaseImpl(taxNumberAvailableUseCase, emailAvailableUseCase, createUserGateway);
    }
}