package com.store.store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "discount")
    private double discount;

    @Column(name = "total")
    private double total;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @Column(name = "fulfilled")
    private String fulfilled;

    @Column(name = "status")
    private String status;

    @Column(name = "bill_date")
    private Date billDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
}
