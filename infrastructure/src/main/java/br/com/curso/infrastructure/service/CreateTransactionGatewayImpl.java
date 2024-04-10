package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.CreateTransactionGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.infrastructure.entity.TransactionEntity;
import br.com.curso.infrastructure.mapper.TransactionMapper;
import br.com.curso.infrastructure.repository.TransactionEntityRepository;

public class CreateTransactionGatewayImpl implements CreateTransactionGateway {

    private TransactionEntityRepository transactionEntityRepository;
    private TransactionMapper transactionMapper;

    public CreateTransactionGatewayImpl(TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Transaction create(Transaction transaction) {
      try {
          var transactionEntity = transactionMapper.createTransaction(transaction);
          return transactionMapper.toTransaction(transactionEntityRepository.save(transactionEntity));
      }catch (Exception ex){
          return null;
      }
    }
}
