package com.store.store.business.dto.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomerResponse {

    private String firstName;

    private String lastName;
}
