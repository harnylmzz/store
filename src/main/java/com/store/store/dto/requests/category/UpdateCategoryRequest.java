package com.store.store.dto.requests.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {

    private int id;

    private String name;

    private String description;

}
