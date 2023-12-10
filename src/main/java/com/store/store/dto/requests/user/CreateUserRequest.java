package com.store.store.dto.requests.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    @NotBlank(message = "Password is mandatory")
    @NotNull(message = "Password is mandatory")
    @Size(min = 6, max = 12, message = "Password must be between 6 and 12 characters")
    private String password;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @NotNull(message = "Email is mandatory")
    private String email;
}
