package dev.jlarsen.resourceserverdemo.services;

import dev.jlarsen.resourceserverdemo.models.Transaction;
import dev.jlarsen.resourceserverdemo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> getAll (String accountNumber) {
        List<Transaction> transactions = new ArrayList<>();
        transactionRepository.findAll().forEach(transactions::add);
        return transactions;
    }
}
