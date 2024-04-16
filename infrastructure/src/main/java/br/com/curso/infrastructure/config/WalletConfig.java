package br.com.curso.infrastructure.config;

import br.com.curso.application.gateway.*;
import br.com.curso.application.usecaseimpl.*;
import br.com.curso.usecase.*;
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
    @Bean
    public TransactionPinValidationUseCase transactionPinValidateUseCase(TransactionPinValidationGateway transactionPinValidateGateway, UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        return new TransactionPinValidationUseCaseImpl(transactionPinValidateGateway, updateTransactionPinUseCase);
    }

    @Bean
    public TransactionValidationUseCase transactionValidationUseCase(TransactionValidationGateway transactionValidationGateway){
        return new TransactionValidationUseCaseImpl(transactionValidationGateway);
    }
    @Bean
    public UserNotificationUseCase userNotificationUseCase(UserNotificationGateway userNotificationGateway) {
        return new UserNotificationUseCaseImpl(userNotificationGateway);
    }

    @Bean
    public CreateTransactionUseCase createTransactionUseCase(CreateTransactionGateway createTransactionGateway) {
        return new CreateTransactionUseCaseImpl(createTransactionGateway);
    }
    @Bean
    public TransferUseCase transferUseCase(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidationUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, TransferGateway transferGateway, UserNotificationUseCase userNotificationUseCase, TransactionPinValidationUseCase transactionPinValidationUseCase) {
        return new TransferUseCaseImpl(findWalletByTaxNumberUseCase, transactionValidateUseCase, createTransactionUseCase, transferGateway, userNotificationUseCase, transactionPinValidationUseCase);
    }

    @Bean
    public UpdateTransactionPinUseCase updateTransactionPinUseCase(UpdateTransactionPinGateway updateTransactionPinGateway) {
        return new UpdateTransactionPinUseCaseImpl(updateTransactionPinGateway);
    }

}
