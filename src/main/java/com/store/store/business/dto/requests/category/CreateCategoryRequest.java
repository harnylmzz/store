package com.store.store.business.dto.requests.category;

import jakarta.persistence.Column;
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
public class CreateCategoryRequest {


    @Size(min = 2, max = 50)
    @NotNull
    @NotBlank
    private String name;

    @Size(min = 2, max = 200)
    @NotNull
    @NotBlank
    private String description;

    @URL
    @NotNull
    @NotBlank
    private String pictureUrl;

}