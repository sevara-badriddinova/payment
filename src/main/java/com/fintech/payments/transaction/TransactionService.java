package com.fintech.payments.transaction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    // interface that talks to database
    // once assigned can't be changed
    private final TransactionRepository transactionRepository;

    // constructor
    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    // jpa turns that into sql insert/update
    public Transaction saveTransaction(Transaction tx){
        return transactionRepository.save(tx);
    }

    // returns list of transactions for user
    public List<Transaction> getUserTransactions(Long userId){
        return transactionRepository.findBySenderIdOrReceiverId(userId, userId);
    }

    public List<Transaction> getAllTransaction(){
        return transactionRepository.findAll();
    }
}
