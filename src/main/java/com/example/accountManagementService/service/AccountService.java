package com.example.accountManagementService.service;

import com.example.accountManagementService.dto.AccountPatchDTO;
import com.example.accountManagementService.dto.AccountRequestDTO;
import com.example.accountManagementService.dto.AccountResponseDTO;
import com.example.accountManagementService.entity.Account;
import com.example.accountManagementService.entity.AccountStatus;
import com.example.accountManagementService.entity.AccountType;
import com.example.accountManagementService.exception.AccountNotFoundException;
import com.example.accountManagementService.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private AccountResponseDTO mapToResponse(Account account) {

        AccountResponseDTO response = new AccountResponseDTO();

        response.setAccountId(account.getAccountId());
        response.setCustomerName(account.getCustomerName());
        response.setEmail(account.getEmail().toLowerCase().trim());
        response.setBalance(account.getBalance());
        response.setAccountType(account.getAccountType());
        response.setStatus(account.getStatus());

        return response;
    }

    public AccountResponseDTO createAccount(AccountRequestDTO requestDTO) {

        Account account = new Account();

        account.setCustomerName(requestDTO.getCustomerName());
        account.setEmail(requestDTO.getEmail().trim().toLowerCase());
        account.setBalance(requestDTO.getBalance());
        account.setAccountType(requestDTO.getAccountType());

        account.setStatus(AccountStatus.ACTIVE);

        Account saved = accountRepository.save(account);

        return mapToResponse(saved);
    }

    public AccountResponseDTO getAccountById(Long accountId) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() ->
                        new AccountNotFoundException(accountId));

        return mapToResponse(account);
    }

    public List<AccountResponseDTO> getAllAccounts(
            AccountType accountType) {

        List<Account> accounts;

        if (accountType != null) {
            accounts = accountRepository.findByAccountType(accountType);
        } else {
            accounts = accountRepository.findAll();
        }

        return accounts.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public AccountResponseDTO updateAccount(
            Long accountId,
            AccountRequestDTO requestDTO) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() ->
                        new AccountNotFoundException(accountId));

        account.setCustomerName(requestDTO.getCustomerName());
        account.setEmail(requestDTO.getEmail().trim().toLowerCase());
        account.setBalance(requestDTO.getBalance());
        account.setAccountType(requestDTO.getAccountType());

        Account updated =
                accountRepository.save(account);

        return mapToResponse(updated);
    }

    public AccountResponseDTO patchAccount(
            Long accountId,
            AccountPatchDTO patchDTO) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() ->
                        new AccountNotFoundException(accountId));

        if (patchDTO.getEmail() != null) {
            account.setEmail(patchDTO.getEmail().trim().toLowerCase());
        }

        if (patchDTO.getStatus() != null) {
            account.setStatus(patchDTO.getStatus());
        }

        Account updated =
                accountRepository.save(account);

        return mapToResponse(updated);
    }
}
