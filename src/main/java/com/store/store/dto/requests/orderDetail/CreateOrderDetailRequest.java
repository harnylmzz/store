package com.store.store.dto.requests.orderDetail;

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
public class CreateOrderDetailRequest {

    @NotNull
    private int quantity;

    @NotNull
    private double unitPrice;

    @NotNull
    private double discount;

    @NotNull
    private double total;

    @NotNull(message = "Size is required")
    @NotBlank(message = "Size is required")
    @Size(min = 1, max = 100, message = "Size must be between 1 and 100 characters")
    private String size;

    @NotNull(message = "Color is required")
    @NotBlank(message = "Color is required")
    @Size(min = 1, max = 15, message = "Color must be between 1 and 15 characters")
    private String color;

    @NotNull(message = "Fulfilled is required")
    @NotBlank(message = "Fulfilled is required")
    @Size(min = 1, max = 15, message = "Fulfilled must be between 1 and 15 characters")
    private String fulfilled;

    @NotNull(message = "Status is required")
    @NotBlank(message = "Status is required")
    @Size(min = 1, max = 15, message = "Status must be between 1 and 15 characters")
    private String status;

    @NotNull
    private Date billDate;
}
