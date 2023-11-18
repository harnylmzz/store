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
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "allowed")
    private boolean allowed;

    @Column(name = "credit_card_host_name")
    private String creditCardHostName;

    @Column(name = "credit_card_number")
    private String creditCardNumber;

    @Column(name = "credit_card_type")
    private String creditCardType;

    @Column(name = "credit_card_date")
    private Date creditCardDate;

    @Column(name = "credit_card_cvv")
    private int creditCardCvv;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
