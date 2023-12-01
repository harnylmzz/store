package com.store.store.business.dto.responses.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCategoryResponses {

    private int id;
    private String name;
    private String description;
}
