package com.store.store.dto.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdProductResponses {

    private int id;

    private String name;

    private String description;

    private String pictureUrl;

    private double price;

    private int unitInStock;

}
