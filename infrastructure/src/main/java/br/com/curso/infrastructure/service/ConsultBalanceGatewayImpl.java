package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.ConsultBalanceGateway;
import br.com.curso.core.domain.Wallet;
import br.com.curso.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConsultBalanceGatewayImpl implements ConsultBalanceGateway {

    private WalletEntityRepository walletEntityRepository;
    @Override
    public BigDecimal consult(Wallet wallet) {
        return null;
    }
}
