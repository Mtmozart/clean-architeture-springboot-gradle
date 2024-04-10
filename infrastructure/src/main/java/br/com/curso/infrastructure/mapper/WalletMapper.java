package br.com.curso.infrastructure.mapper;

import br.com.curso.core.domain.Wallet;
import br.com.curso.infrastructure.entity.TransactionPinEntity;
import br.com.curso.infrastructure.entity.UserEntity;
import br.com.curso.infrastructure.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    private TransactionPinMapper transactionPinMapper;
    private UserMapper userMapper;

    public WalletMapper(TransactionPinMapper transactionPinMapper) {
        this.transactionPinMapper = transactionPinMapper;
    }

    public WalletEntity toWalletEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity){
        return new WalletEntity(
                wallet.getBalance(),
                userEntity,
                transactionPinEntity,
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }

    public WalletEntity toWalletEntity(Wallet wallet){
        return new WalletEntity(
                wallet.getBalance(),
                userMapper.toUserEntity(wallet.getUser()),
                transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()),
                wallet.getCreatedAt(),
                wallet.getUpdateAt()
        );
    }

    public Wallet toWallet(WalletEntity walletEntity) throws Exception {
        if(walletEntity == null){
            return null;
        }
        return new Wallet(
                walletEntity.getId(),
                transactionPinMapper.toTransactionPin(walletEntity.getTransactionPinEntity()),
                walletEntity.getBalance(),
                userMapper.toUser(walletEntity.getUserEntity()),
                walletEntity.getCreatedAt(),
                walletEntity.getUpdatedAt()
        );
    }
}
