package com.store.store.business.abstracts;

import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.address.CreateAddressRequest;
import com.store.store.dto.requests.address.DeleteAddressRequest;
import com.store.store.dto.requests.address.UpdateAddressRequest;
import com.store.store.dto.responses.address.GetAllAddressResponses;
import com.store.store.dto.responses.address.GetByIdAddressResponse;

import java.util.List;

public interface AddressService {

    DataResult<List<GetAllAddressResponses>> getAll();

    DataResult<GetByIdAddressResponse> getById(int id);

    Result add(CreateAddressRequest createAddressRequest);

    Result update(UpdateAddressRequest updateAddressRequest);

    Result delete(DeleteAddressRequest deleteAddressRequest);
}
