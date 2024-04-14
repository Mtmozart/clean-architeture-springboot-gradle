package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.TransferGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.infrastructure.entity.TransactionEntity;
import br.com.curso.infrastructure.mapper.TransactionMapper;
import br.com.curso.infrastructure.mapper.WalletMapper;
import br.com.curso.infrastructure.repository.TransactionEntityRepository;
import br.com.curso.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferGatewayImpl implements TransferGateway {
    private WalletEntityRepository walletEntityRepository;
    private TransactionEntityRepository transactionEntityRepository;
    private WalletMapper walletMapper;
    private TransactionMapper transactionMapper;
    public TransferGatewayImpl(WalletEntityRepository walletEntityRepository, TransactionEntityRepository transactionEntityRepository, WalletMapper walletMapper, TransactionMapper transactionMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.transactionEntityRepository = transactionEntityRepository;
        this.walletMapper = walletMapper;
        this.transactionMapper = transactionMapper;
    }

    @Override
    @Transactional
    public Boolean transfer(Transaction transaction) {
       try{
           walletEntityRepository.save(walletMapper.toWalletEntityUpdate(transaction.getFromWallet()));
           walletEntityRepository.save(walletMapper.toWalletEntityUpdate(transaction.getToWallet()));

           transactionEntityRepository.save(transactionMapper.concludeTransaction(transaction));

           return true;
       }catch (Exception ex){
           transactionEntityRepository.save(transactionMapper.cancelTransaction(transaction));
            return false;
       }
    }
}
