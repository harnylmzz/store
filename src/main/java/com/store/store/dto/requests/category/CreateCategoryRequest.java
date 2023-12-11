package com.store.store.dto.requests.category;

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
    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    private String name;

    @Size(min = 2, max = 200)
    @NotNull(message = "Description is required")
    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Picture url is required")
    @NotBlank(message = "Picture url is required")
    private String pictureUrl;

}