package com.example.accountManagementService.dto;

import com.example.accountManagementService.entity.AccountStatus;
import com.example.accountManagementService.entity.AccountType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

}