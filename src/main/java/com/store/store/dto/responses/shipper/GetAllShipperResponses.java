package com.store.store.dto.responses.shipper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllShipperResponses {

    private int id;

    private String name;

    private String phone;
}
