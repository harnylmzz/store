package com.store.store.dto.requests.invoice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceRequest {

    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    private String number;

    private Date date;
}
