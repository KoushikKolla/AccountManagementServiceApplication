package com.example.accountManagementService.dto;

import com.example.accountManagementService.entity.AccountStatus;

public class AccountPatchDTO {

    private String email;
    private AccountStatus status;

    public AccountPatchDTO() {
    }

    public AccountPatchDTO(String email, AccountStatus status) {
        this.email = email;
        this.status = status;
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
