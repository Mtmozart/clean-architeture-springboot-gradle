package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.CreateUserGeteway;
import br.com.curso.core.domain.User;
import br.com.curso.core.domain.Wallet;
import br.com.curso.infrastructure.mapper.TransactionPinMapper;
import br.com.curso.infrastructure.mapper.UserMapper;
import br.com.curso.infrastructure.mapper.WalletMapper;
import br.com.curso.infrastructure.repository.TransactionPinEntityRepository;
import br.com.curso.infrastructure.repository.UserEntityRepository;
import br.com.curso.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;
import static br.com.curso.infrastructure.utils.Utilities.log;

@Service
public class CreateUserGetewayImpl implements CreateUserGeteway {

    private UserEntityRepository userEntityRepository;
    private UserMapper userMapper;
    private TransactionPinEntityRepository transactionPinEntityRepository;
    private TransactionPinMapper transactionPinMapper;
    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;

    public CreateUserGetewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper, TransactionPinEntityRepository transactionPinEntityRepository, TransactionPinMapper transactionPinMapper, WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.transactionPinMapper = transactionPinMapper;
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Boolean create(User user, Wallet wallet) {
        try{
            log.info("Iniciando criação do usuário::CreateUserGetewayImpl");
            var userSaved = userEntityRepository.save(userMapper.toUserEntity(user));
            var transactionPinSaved = transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()));
            walletEntityRepository.save(walletMapper.toWalletEntity(wallet, userSaved, transactionPinSaved));
            log.info("Usuário criado com sucesso::CreateUserGetewayImpl");
            return true;
        }catch (Exception e){
            log.error("Erro na criação do usuário::CreateUserGetewayImpl");
            return false;
        }
    }
}
