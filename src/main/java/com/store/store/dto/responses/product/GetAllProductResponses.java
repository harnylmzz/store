package com.store.store.dto.responses.product;

import jakarta.persistence.Column;
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

    private String pictureUrl;

    private double price;

    private int unitInStock;
}
