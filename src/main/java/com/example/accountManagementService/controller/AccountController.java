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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Tag(
        name = "Account APIs",
        description = "Account Management Operations"
)
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(
            summary = "Create Account",
            description = "Creates a new account"
    )
    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(
            @Valid @RequestBody AccountRequestDTO requestDTO) {

        AccountResponseDTO response =
                accountService.createAccount(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @Operation(
            summary = "Get Account By Id",
            description = "Fetch account details using account id"
    )
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponseDTO> getAccountById(
            @PathVariable Long accountId) {

        return ResponseEntity.ok(
                accountService.getAccountById(accountId));
    }
    @Operation(
            summary = "Get All Accounts",
            description = "Returns all accounts or filter by account type"
    )
    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>>
    getAllAccounts(
            @RequestParam(required = false)
            AccountType accountType) {

        return ResponseEntity.ok(
                accountService.getAllAccounts(accountType));
    }
    @Operation(
            summary = "Update Account",
            description = "Updates entire account information"
    )
    @PutMapping("/{accountId}")
    public ResponseEntity<AccountResponseDTO> updateAccount(
            @PathVariable Long accountId,
            @Valid @RequestBody AccountRequestDTO requestDTO) {

        return ResponseEntity.ok(
                accountService.updateAccount(
                        accountId,
                        requestDTO));
    }
    @Operation(
            summary = "Patch Account",
            description = "Updates selected account fields"
    )
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