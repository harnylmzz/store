package com.store.store.dto.requests.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {

    private int id;

    private String name;

    private String description;

    private String pictureUrl;

    private double price;

    private int unitInStock;

    private int unitInOrder;

    private int reorderLevel;

    private boolean discontinued;

    private String size;

    private String color;

    private String weight;

    private String discount;

    private int categoryId;
}
