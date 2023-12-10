package com.store.store.dto.responses.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSupplierResponses {

    private int id;

    private String companyName;

    private String logoUrl;

}
