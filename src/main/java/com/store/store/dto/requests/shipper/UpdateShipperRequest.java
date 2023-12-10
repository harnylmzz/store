package com.store.store.dto.requests.shipper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateShipperRequest {

    private int id;

    private String name;

    private String phone;
}
