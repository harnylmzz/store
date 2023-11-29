package com.store.store.business.dto.requests.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    @NotBlank
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 50)
    private String phone;

}
