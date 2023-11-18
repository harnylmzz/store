package com.store.store.business.abstracts;

import com.store.store.core.result.DataResult;
import com.store.store.dto.responses.address.GetAllAddressResponses;

import java.util.List;

public interface AddressService {

    DataResult<List<GetAllAddressResponses>> getAll();
}
