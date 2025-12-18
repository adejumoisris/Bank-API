package com.example.bankapi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
    private BigDecimal amount;
    private  String transactionType;
    private String description;
    private BigDecimal transactionBefore;
    private BigDecimal transactionAfter;
    private LocalDateTime createdAt;


    public Transaction(Long id, BigDecimal amount, String transactionType, String description, BigDecimal transactionBefore, BigDecimal transactionAfter, LocalDateTime createdAt) {
        this.id = id;
        this.amount = amount;
        this.transactionType = transactionType;
        this.description = description;
        this.transactionBefore = transactionBefore;
        this.transactionAfter = transactionAfter;
        this.createdAt = createdAt;
    }

    public Transaction() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTransactionBefore() {
        return transactionBefore;
    }

    public void setTransactionBefore(BigDecimal transactionBefore) {
        this.transactionBefore = transactionBefore;
    }

    public BigDecimal getTransactionAfter() {
        return transactionAfter;
    }

    public void setTransactionAfter(BigDecimal transactionAfter) {
        this.transactionAfter = transactionAfter;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", description='" + description + '\'' +
                ", transactionBefore=" + transactionBefore +
                ", transactionAfter=" + transactionAfter +
                ", createdAt=" + createdAt +
                '}';
    }
}
