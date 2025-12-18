package com.example.bankapi.repository;

import com.example.bankapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
//    adding pagination to it
    Optional<Account> findByAccountNumber(String accountNumber);
}
