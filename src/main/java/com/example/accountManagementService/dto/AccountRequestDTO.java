package com.example.accountManagementService.dto;

import com.example.accountManagementService.entity.AccountStatus;
import com.example.accountManagementService.entity.AccountType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AccountRequestDTO {

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotNull(message = "Account type is required")
    private AccountType accountType;

    @Positive(message = "Balance should be greater than zero")
    private Long balance;

    @Email(message = "Invalid email")
    private String email;

    public AccountRequestDTO() {
    }

    public AccountRequestDTO(String customerName, AccountType accountType, Long balance, String email) {
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
        this.email = email;
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
}