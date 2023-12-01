package com.store.store.business.abstracts;

import com.store.store.business.dto.requests.category.UpdateCategoryRequest;
import com.store.store.business.dto.responses.category.GetByIdCategoryResponses;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.business.dto.requests.category.CreateCategoryRequest;
import com.store.store.business.dto.requests.category.DeleteCategoryRequest;
import com.store.store.business.dto.responses.category.GetAllCategoryResponses;

import javax.xml.crypto.Data;
import java.util.List;

public interface CategoryService {

    DataResult<List<GetAllCategoryResponses>> getAll();

    DataResult<GetByIdCategoryResponses> getById(int id);

    Result add(CreateCategoryRequest createCategoryRequest);

    Result delete(DeleteCategoryRequest deleteCategoryRequest);

    Result update(UpdateCategoryRequest updateCategoryRequest);

}
