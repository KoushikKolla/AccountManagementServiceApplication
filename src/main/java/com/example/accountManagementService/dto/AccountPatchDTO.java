package com.example.accountManagementService.dto;

import com.example.accountManagementService.entity.AccountStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountPatchDTO {
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;
    private AccountStatus status;
}
