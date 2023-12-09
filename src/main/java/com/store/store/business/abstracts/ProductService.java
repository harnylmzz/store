package com.store.store.business.abstracts;

import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.product.CreateProductRequest;
import com.store.store.dto.requests.product.DeleteProductRequest;
import com.store.store.dto.requests.product.UpdateProductRequest;
import com.store.store.dto.responses.product.GetAllProductResponses;
import com.store.store.dto.responses.product.GetByIdProductResponses;

import java.util.List;

public interface ProductService {

    DataResult<List<GetAllProductResponses>> getAll();

    DataResult<GetByIdProductResponses> getById(int id);

    Result add(CreateProductRequest createProductRequest);

    Result update(UpdateProductRequest updateProductRequest);

    Result delete(DeleteProductRequest deleteProductRequestL);
 }
