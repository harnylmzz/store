package com.store.store.business.abstracts;

import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.supplier.CreateSupplierRequest;
import com.store.store.dto.requests.supplier.DeleteSupplierRequest;
import com.store.store.dto.requests.supplier.UpdateSupplierRequest;
import com.store.store.dto.responses.supplier.GetAllSupplierResponses;
import com.store.store.dto.responses.supplier.GetByIdSupplierResponses;

import java.util.List;

public interface SupplierService {

    DataResult<List<GetAllSupplierResponses>> getAll();

    DataResult<GetByIdSupplierResponses> getById(int id);

    Result add(CreateSupplierRequest createSupplierRequest);

    Result update(UpdateSupplierRequest updateSupplierRequest);

    Result delete(DeleteSupplierRequest deleteSupplierRequest);
}
