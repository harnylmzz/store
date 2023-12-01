package com.store.store.business.dto.responses.invoice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInvoiceResponses {

    private int id;

    private String number;

    private Date date;
}
