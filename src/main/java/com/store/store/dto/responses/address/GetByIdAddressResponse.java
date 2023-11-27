package com.store.store.dto.responses.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdAddressResponse {

    private String country;

    private String city;

    private String street;

    private String address;

    private String zipCode;
}
