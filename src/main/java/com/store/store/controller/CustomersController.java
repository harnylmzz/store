package com.store.store.controller;

import com.store.store.business.abstracts.CustomerService;
import com.store.store.business.dto.responses.customer.GetAllCustomerResponse;
import com.store.store.business.dto.responses.customer.GetByIdCustomerResponse;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.result.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CustomersController {

    private CustomerService customerService;
    private ModelMapperService modelMapperService;

    @GetMapping("/getall")
    public DataResult<List<GetAllCustomerResponse>> getAll() {
        return this.customerService.getAll();

    }

    @GetMapping("/getById")
    public DataResult<GetByIdCustomerResponse> getById(int id) {
        return this.customerService.getById(id);
    }
}