package com.store.store.dto.responses.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllOrderDetailResponses {

    private int id;
    private int quantity;
    private double unitPrice;
}
