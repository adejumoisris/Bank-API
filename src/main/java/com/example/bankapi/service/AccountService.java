package com.example.bankapi.service;

import com.example.bankapi.exceptions.AccountNotFoundException;
import com.example.bankapi.model.Account;
import com.example.bankapi.model.Transaction;
import com.example.bankapi.repository.AccountRepository;
import com.example.bankapi.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;


    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public BigDecimal getBalance(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account not Found for account number: " + accountNumber));
        return account.getBalance();
    }

    public Account getAccountDetails(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not Found"));
    }

    public List<Transaction> getTransactionsHistory(String accountNumber) {
        return transactionRepository.findByAccount_AccountNumber(accountNumber);

    }
}
