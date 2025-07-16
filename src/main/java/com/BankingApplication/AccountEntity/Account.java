package com.BankingApplication.Account;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Account number is required")
    @Column(unique = true)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @DecimalMin(value = "0.0", message = "Balance must be positive")
    private BigDecimal balance;


}
