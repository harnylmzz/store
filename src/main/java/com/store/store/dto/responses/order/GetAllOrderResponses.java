package com.store.store.dto.responses.order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllOrderResponses {

    private int id;

    private int number;

    private Date date;

    private String status;

    private String comment;

    private String freight;

    private int total;

}
