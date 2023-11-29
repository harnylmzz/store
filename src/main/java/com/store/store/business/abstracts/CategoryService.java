package com.store.store.business.abstracts;

import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.business.dto.requests.category.CreateCategoryRequest;
import com.store.store.business.dto.requests.category.DeleteCategoryRequest;
import com.store.store.business.dto.responses.category.GetAllCategoryResponses;

import java.util.List;

public interface CategoryService {

    DataResult<List<GetAllCategoryResponses>> getAll();
    Result add(CreateCategoryRequest createCategoryRequest);
    Result delete(DeleteCategoryRequest deleteCategoryRequest);

}
