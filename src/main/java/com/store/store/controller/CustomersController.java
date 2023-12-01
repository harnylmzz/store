package com.store.store.controller;

import com.store.store.business.abstracts.CustomerService;
import com.store.store.business.dto.requests.customer.CreateCustomerRequest;
import com.store.store.business.dto.requests.customer.DeleteCustomerRequest;
import com.store.store.business.dto.requests.customer.UpdateCustomerRequest;
import com.store.store.business.dto.responses.customer.GetAllCustomerResponses;
import com.store.store.business.dto.responses.customer.GetByIdCustomerResponses;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomersController {

    private CustomerService customerService;
    private ModelMapperService modelMapperService;

    @GetMapping("/getall")
    public DataResult<List<GetAllCustomerResponses>> getAll() {
        return this.customerService.getAll();

    }

    @GetMapping("/getById")
    public DataResult<GetByIdCustomerResponses> getById(int id) {
        return this.customerService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateCustomerRequest createCustomerRequest) {
        return this.customerService.add(createCustomerRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return this.customerService.update(updateCustomerRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteCustomerRequest deleteCustomerRequest) {
        return this.customerService.delete(deleteCustomerRequest);
    }
}