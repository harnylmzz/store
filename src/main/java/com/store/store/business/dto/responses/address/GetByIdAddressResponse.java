package com.store.store.business.dto.responses.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdAddressResponse {

    private int id;

    private String country;

    private String city;

}
