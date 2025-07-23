package com.BankingApplication.AccountController;

import com.BankingApplication.AccountEntity.Account;
import com.BankingApplication.AccountService.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account/")
public class AccountController {
    public AccountService accountService;
    @GetMapping()
    public List<Account> getAllAccount(){
        List<Account> allAccounts = accountService.getAllAccounts();
        return allAccounts;
    }

    @GetMapping("{id}")
    public Account getAccountById(@PathVariable Long id){
        if(id==null){
            throw  new RuntimeException("Id not exist !!!!");
        }else{
            return accountService.getAccountById(id);
        }
    }

    @GetMapping("{accountNumber}")
    public Account getAccountByAccountNumber(@PathVariable String accountNumber){
        return accountService.getAccountByNumber(accountNumber);
    }

//    @PostMapping()
//    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
//        Account saveAccount = accountService.createAccount(account);
//        return new ResponseEntity<>(saveAccount, HttpStatus.CREATED);
//    }


}
