package com.example.accountManagementService.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(Long accountId) {
        super("Account Not Found with id : " + accountId);
    }
}