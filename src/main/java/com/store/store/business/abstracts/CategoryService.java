package com.store.store.business.abstracts;

import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.category.CreateCategoryRequest;
import com.store.store.dto.requests.category.DeleteCategoryRequest;
import com.store.store.dto.responses.category.GetAllCategoryResponses;

import java.util.List;

public interface CategoryService {

    DataResult<List<GetAllCategoryResponses>> getAll();
    Result add(CreateCategoryRequest createCategoryRequest);
    Result delete(DeleteCategoryRequest deleteCategoryRequest);

}
