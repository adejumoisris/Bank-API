package com.example.bankapi.service;

import com.example.bankapi.exceptions.AccountNotFoundException;
import com.example.bankapi.model.Account;
import com.example.bankapi.model.Transaction;
import com.example.bankapi.repository.AccountRepository;
import com.example.bankapi.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final AuditLogService auditLogService;

    private static final Logger log = LoggerFactory.getLogger(AccountService.class);


    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository, AuditLogService auditLogService) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.auditLogService = auditLogService;
    }

    public BigDecimal getBalance(String accountNumber, String userId, String ipAddress) {
        log.info("Getting balance for account {}", accountNumber);
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> {
                    auditLogService.logAction(
                            userId,
                            "View_Balance",
                            accountNumber,
                            "Failed",
                            ipAddress
                    );
                        log.warn("Account not found: {}", accountNumber);
                      return   new AccountNotFoundException("Account not Found for account number: " + accountNumber);
                });
        log.info("Account balance: {}", account.getBalance());
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
