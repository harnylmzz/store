package com.store.store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "price")
    private double price;

    @Column(name = "units_in_stock")
    private int unitInStock;

    @Column(name = "units_in_order")
    private int unitInOrder;

    @Column(name = "reorder_level")
    private int reorderLevel;

    @Column(name = "discontinued")
    private boolean discontinued;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @Column(name = "weight")
    private String weight;

    @Column(name = "discount")
    private String discount;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
