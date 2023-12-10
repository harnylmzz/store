package com.store.store.dto.requests.supplier;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSupplierRequest {

    @NotNull(message = "Company name cannot be null")
    @NotBlank(message = "Company name cannot be blank")
    @Size(min = 2, max = 50, message = "Company name must be between 2 and 50 characters")
    private String companyName;

    @NotNull(message = "Contact name cannot be null")
    @NotBlank(message = "Contact name cannot be blank")
    @Size(min = 2, max = 50, message = "Contact name must be between 2 and 50 characters")
    private String contactName;

    @NotNull(message = "Contact title cannot be null")
    @NotBlank(message = "Contact title cannot be blank")
    @Size(min = 2, max = 50, message = "Contact title must be between 2 and 50 characters")
    private String contactTitle;

    @NotNull(message = "Phone cannot be null")
    @NotBlank(message = "Phone cannot be blank")
    @Size(min = 11, max = 11, message = "Phone must be 11 characters")
    private String phone;

    @NotNull(message = "Fax cannot be null")
    @NotBlank(message = "Fax cannot be blank")
    private String fax;

    @Email(message = "Email must be a valid email")
    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @URL(message = "Logo URL must be a valid URL")
    @NotBlank(message = "Logo URL cannot be blank")
    private String logoUrl;
}
