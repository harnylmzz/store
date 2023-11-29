package com.store.store.business.concretes;

import com.store.store.business.abstracts.CustomerService;
import com.store.store.business.dto.requests.customer.CreateCustomerRequest;
import com.store.store.business.dto.requests.customer.DeleteCustomerRequest;
import com.store.store.business.dto.requests.customer.UpdateCustomerRequest;
import com.store.store.business.dto.responses.customer.GetAllCustomerResponse;
import com.store.store.business.dto.responses.customer.GetByIdCustomerResponse;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.core.result.SuccessResult;
import com.store.store.model.Customer;
import com.store.store.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllCustomerResponse>> getAll() {

        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomerResponse> getAllCustomerResponses = customers.stream()
                .map(customer -> this.modelMapperService.forResponse()
                        .map(customer, GetAllCustomerResponse.class))
                .collect(Collectors.toList());
        return new DataResult<>(getAllCustomerResponses, true, "All customers listed.");

    }

    @Override
    public DataResult<GetByIdCustomerResponse> getById(int id) {

        Customer customer = customerRepository.findById(id).orElseThrow();
        GetByIdCustomerResponse getByIdCustomerResponse = this.modelMapperService.forResponse()
                .map(customer, GetByIdCustomerResponse.class);
        return new DataResult<>(getByIdCustomerResponse, true, "Customer listed.");
    }

    @Override
    public Result add(CreateCustomerRequest createCustomerRequest) {

        Customer customer = this.modelMapperService.forRequest()
                .map(createCustomerRequest, Customer.class);
        return new SuccessResult("Customer added.");
    }

    @Override
    public Result update(UpdateCustomerRequest updateCustomerRequest) {

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
