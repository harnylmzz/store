package com.store.store.dto.requests.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderDetailRequest {

    private int id;

    private int quantity;

    private double unitPrice;

    private double discount;

    private double total;

    private String size;

    private String color;

    private String fulfilled;

    private String status;

    private Date billDate;
}
