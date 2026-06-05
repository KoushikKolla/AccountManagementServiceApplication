package com.example.accountManagementService.dto;

import com.example.accountManagementService.entity.AccountStatus;
import com.example.accountManagementService.entity.AccountType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
    @NotBlank(message = "Email is required")
    private String email;

    public AccountRequestDTO() {
    }

    public AccountRequestDTO(String customerName, AccountType accountType, Long balance, String email) {
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
        this.email = email;
    }

}