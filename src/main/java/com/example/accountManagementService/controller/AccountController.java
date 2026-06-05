package com.example.accountManagementService.controller;

import com.example.accountManagementService.dto.AccountPatchDTO;
import com.example.accountManagementService.dto.AccountRequestDTO;
import com.example.accountManagementService.dto.AccountResponseDTO;
import com.example.accountManagementService.entity.AccountType;
import com.example.accountManagementService.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(
            @Valid @RequestBody AccountRequestDTO requestDTO) {

        AccountResponseDTO response =
                accountService.createAccount(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponseDTO> getAccountById(
            @PathVariable Long accountId) {

        return ResponseEntity.ok(
                accountService.getAccountById(accountId));
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>>
    getAllAccounts(
            @RequestParam(required = false)
            AccountType accountType) {

        return ResponseEntity.ok(
                accountService.getAllAccounts(accountType));
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<AccountResponseDTO> updateAccount(
            @PathVariable Long accountId,
            @Valid @RequestBody AccountRequestDTO requestDTO) {

        return ResponseEntity.ok(
                accountService.updateAccount(
                        accountId,
                        requestDTO));
    }

    @PatchMapping("/{accountId}")
    public ResponseEntity<AccountResponseDTO> patchAccount(
            @PathVariable Long accountId,
            @RequestBody AccountPatchDTO patchDTO) {

        return ResponseEntity.ok(
                accountService.patchAccount(
                        accountId,
                        patchDTO));
    }
}