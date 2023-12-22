package com.store.store.dto.requests.product;

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
public class CreateProductRequest {

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Description cannot be null")
    @NotBlank(message = "Description cannot be blank")
    @Size(min = 2, max = 50, message = "Description must be between 2 and 50 characters")
    private String description;

    @URL(message = "Picture URL must be a valid URL")
    @NotNull(message = "Picture URL cannot be null")
    @NotBlank(message = "Picture URL cannot be blank")
    private String pictureUrl;

    @NotNull
    private double price;

    @NotNull
    private int unitInStock;

    @NotNull
    private int unitInOrder;

    @NotNull
    private int reorderLevel;

    @NotNull
    private boolean discontinued;

    @NotNull(message = "Size cannot be null")
    @NotBlank(message = "Size cannot be blank")
    @Size(min = 2, max = 50, message = "Size must be between 2 and 50 characters")
    private String size;

    @NotNull(message = "Color cannot be null")
    @NotBlank(message = "Color cannot be blank")
    @Size(min = 2, max = 50, message = "Color must be between 2 and 50 characters")
    private String color;

    @NotNull(message = "Weight cannot be null")
    @NotBlank(message = "Weight cannot be blank")
    @Size(min = 2, max = 50, message = "Weight must be between 2 and 50 characters")
    private String weight;

    @NotNull(message = "Discount cannot be null")
    @NotBlank(message = "Discount cannot be blank")
    @Size(min = 2, max = 50, message = "Discount must be between 2 and 50 characters")
    private String discount;

    private int categoryId;
}
