package com.BankingApplication.AccountRepository;

import com.BankingApplication.AccountEntity.Account;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
public Optional<Account> findByAccountNumber(String accountNumber);
}
