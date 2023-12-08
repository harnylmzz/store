package com.store.store.dto.requests.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {

    private int id;

    private int number;

    private Date date;

    private String status;

    private String comment;

    private String freight;

    private double total;

    private String tax;
}
