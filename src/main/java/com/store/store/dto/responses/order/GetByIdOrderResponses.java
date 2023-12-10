package com.store.store.dto.responses.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdOrderResponses {

    private int id;

    private int number;

    private String status;

}
