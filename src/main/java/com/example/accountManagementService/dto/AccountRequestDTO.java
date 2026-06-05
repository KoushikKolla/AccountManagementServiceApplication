package com.example.accountManagementService.dto;

import com.example.accountManagementService.entity.AccountStatus;
import com.example.accountManagementService.entity.AccountType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import io.swagger.v3.oas.annotations.media.Schema;

public class AccountRequestDTO {

    @Schema(example = "John Doe")
    @NotBlank(message = "Customer name is required")
    private String customerName;

    @Schema(example = "SAVINGS")
    @NotNull(message = "Account type is required")
    private AccountType accountType;

    @Schema(example = "5000")
    @Positive(message = "Balance should be greater than zero")
    private Long balance;

    @Schema(example = "john@test.com")
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