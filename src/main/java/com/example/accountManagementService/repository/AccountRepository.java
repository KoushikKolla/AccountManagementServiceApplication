package com.example.accountManagementService.repository;

import com.example.accountManagementService.entity.Account;
import com.example.accountManagementService.entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findByAccountType(AccountType accountType);
}
