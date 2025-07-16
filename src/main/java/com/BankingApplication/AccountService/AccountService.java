package com.BankingApplication.AccountService;

import com.BankingApplication.AccountEntity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    Account getAccountById(Long id);
    Account getAccountByNumber(String accountNumber);
    List<Account> getAllAccounts();

//    void deleteAccount(Long id);
//    Account updateAccount(Account account);
    Long checkBalance(String accountNumber);
}
