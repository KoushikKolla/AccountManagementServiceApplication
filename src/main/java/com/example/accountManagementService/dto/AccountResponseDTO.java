package com.example.accountManagementService.dto;

import com.example.accountManagementService.entity.AccountStatus;
import com.example.accountManagementService.entity.AccountType;

public class AccountResponseDTO {

    private Long accountId;
    private String customerName;
    private AccountType accountType;
    private Long balance;
    private String email;
    private AccountStatus status;

    public AccountResponseDTO() {
    }

    public AccountResponseDTO(Long accountId, String customerName, AccountType accountType, Long balance, String email, AccountStatus status) {
        this.accountId = accountId;
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
        this.email = email;
        this.status = status;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}