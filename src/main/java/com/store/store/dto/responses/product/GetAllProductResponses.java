package com.store.store.dto.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponses {

    private int id;

    private String name;

    private String description;

    private double price;

    private int categoryId;

}
