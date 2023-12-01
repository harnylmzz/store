package com.store.store.business.abstracts;

import com.store.store.dto.requests.customer.CreateCustomerRequest;
import com.store.store.dto.requests.customer.DeleteCustomerRequest;
import com.store.store.dto.requests.customer.UpdateCustomerRequest;
import com.store.store.dto.responses.customer.GetAllCustomerResponses;
import com.store.store.dto.responses.customer.GetByIdCustomerResponses;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;

import java.util.List;

public interface CustomerService {

    DataResult<List<GetAllCustomerResponses>> getAll();

    DataResult<GetByIdCustomerResponses> getById(int id);

    Result add(CreateCustomerRequest createCustomerRequest);

    Result update(UpdateCustomerRequest updateCustomerRequest);

    Result delete(DeleteCustomerRequest deleteCustomerRequest);
}
