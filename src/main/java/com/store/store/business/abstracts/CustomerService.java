package com.store.store.business.abstracts;

import com.store.store.business.dto.requests.customer.CreateCustomerRequest;
import com.store.store.business.dto.requests.customer.DeleteCustomerRequest;
import com.store.store.business.dto.requests.customer.UpdateCustomerRequest;
import com.store.store.business.dto.responses.customer.GetAllCustomerResponse;
import com.store.store.business.dto.responses.customer.GetByIdCustomerResponse;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;

import java.util.List;

public interface CustomerService {

    DataResult<List<GetAllCustomerResponse>> getAll();

    DataResult<GetByIdCustomerResponse> getById(int id);

    Result add(CreateCustomerRequest createCustomerRequest);

    Result update(UpdateCustomerRequest updateCustomerRequest);

    Result delete(DeleteCustomerRequest deleteCustomerRequest);
}
