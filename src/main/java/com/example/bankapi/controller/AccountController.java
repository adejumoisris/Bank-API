package com.example.bankapi.controller;

import com.example.bankapi.model.Account;
import com.example.bankapi.model.Transaction;
import com.example.bankapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/accounts")

public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountNumber}/balance")
    public BigDecimal getBalance(@PathVariable String accountNumber) {
        return accountService.getBalance(accountNumber);
    }

    @GetMapping("/{accountNumber}")
    public Account getAccountDetails(@PathVariable String accountNumber) {
        return accountService.getAccountDetails(accountNumber);
    }
    @GetMapping("/{accountNumber}/transaction")
    public List<Transaction> getTransactions(@PathVariable String accountNumber) {
        return accountService.getTransactionsHistory(accountNumber);

    }
}
