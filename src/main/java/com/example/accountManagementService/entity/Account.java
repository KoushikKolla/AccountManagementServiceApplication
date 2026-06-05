package com.example.accountManagementService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String customerName;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long balance;
    private String email;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    public Account() {
    }

    public Account(Long accountId, String customerName, AccountType accountType, Long balance, String email, AccountStatus status) {
        this.accountId = accountId;
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
        this.email = email;
        this.status = status;
    }

}