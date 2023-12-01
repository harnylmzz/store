package com.store.store.business.concretes;

import com.store.store.business.abstracts.CustomerService;
import com.store.store.business.dto.requests.customer.CreateCustomerRequest;
import com.store.store.business.dto.requests.customer.DeleteCustomerRequest;
import com.store.store.business.dto.requests.customer.UpdateCustomerRequest;
import com.store.store.business.dto.responses.customer.GetAllCustomerResponses;
import com.store.store.business.dto.responses.customer.GetByIdCustomerResponses;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.exceptions.DataNotFoundException;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.core.result.SuccessResult;
import com.store.store.model.Customer;
import com.store.store.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllCustomerResponses>> getAll() {

        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomerResponses> getAllCustomerResponses = customers.stream()
                .map(customer -> this.modelMapperService.forResponse()
                        .map(customer, GetAllCustomerResponses.class))
                .collect(Collectors.toList());
        return new DataResult<>(getAllCustomerResponses, true, "All customers listed.");

    }

    @Override
    public DataResult<GetByIdCustomerResponses> getById(int id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Customer not found."));
        GetByIdCustomerResponses getByIdCustomerResponse = this.modelMapperService.forResponse()
                .map(customer, GetByIdCustomerResponses.class);
        return new DataResult<>(getByIdCustomerResponse, true, "Customer listed.");
    }

    @Override
    public Result add(@RequestBody @Valid CreateCustomerRequest createCustomerRequest) {

        Customer customer = this.modelMapperService.forRequest()
                .map(createCustomerRequest, Customer.class);

        this.customerRepository.save(customer);
        return new SuccessResult("Customer added.");
    }

    @Override
    public Result update(@RequestBody UpdateCustomerRequest updateCustomerRequest) {

        Customer customer = this.modelMapperService.forRequest()
                .map(updateCustomerRequest, Customer.class);
        customer.setId(updateCustomerRequest.getId());
        customer.setFirstName(updateCustomerRequest.getFirstName());
        customer.setLastName(updateCustomerRequest.getLastName());
        customer.setPhone(updateCustomerRequest.getPhone());

        this.customerRepository.save(customer);

        return new SuccessResult("Customer updated.");
    }

    @Override
    public Result delete(DeleteCustomerRequest deleteCustomerRequest) {

        Customer customer = this.modelMapperService.forRequest()
                .map(deleteCustomerRequest, Customer.class);
        return new SuccessResult("Customer deleted.");
    }
}
