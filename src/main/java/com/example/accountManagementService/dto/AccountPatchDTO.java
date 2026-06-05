package com.example.accountManagementService.dto;

import com.example.accountManagementService.entity.AccountStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountPatchDTO {

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;
    private AccountStatus status;

    public AccountPatchDTO() {
    }

    public AccountPatchDTO(String email, AccountStatus status) {
        this.email = email;
        this.status = status;
    }

}
