package com.store.store.business.dto.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomerResponses {

    private int id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

}
