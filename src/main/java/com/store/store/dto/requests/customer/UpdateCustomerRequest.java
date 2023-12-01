package com.store.store.dto.requests.customer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

    private int id;

    private String firstName;

    private String lastName;

    private String phone;
}
