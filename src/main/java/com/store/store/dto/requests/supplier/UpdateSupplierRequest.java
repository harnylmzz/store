package com.store.store.dto.requests.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSupplierRequest {

    private int id;

    private String companyName;

    private String contactName;

    private String contactTitle;

    private String phone;

    private String fax;

    private String email;

    private String logoUrl;
}
