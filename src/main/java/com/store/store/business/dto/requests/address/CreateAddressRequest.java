package com.store.store.business.dto.requests.address;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {


    @NotBlank
    @NotNull
    @Size(min = 2, max = 50)
    private String country;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 50)
    private String city;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 50)
    private String street;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 150)
    private String address;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 50)
    private String zipCode;
}
