package com.store.store.business.concretes;

import com.store.store.business.abstracts.CategoryService;
import com.store.store.dto.requests.category.UpdateCategoryRequest;
import com.store.store.dto.responses.category.GetByIdCategoryResponses;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.exceptions.DataNotFoundException;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.core.result.SuccessResult;
import com.store.store.dto.requests.category.CreateCategoryRequest;
import com.store.store.dto.requests.category.DeleteCategoryRequest;
import com.store.store.dto.responses.category.GetAllCategoryResponses;
import com.store.store.model.Category;
import com.store.store.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllCategoryResponses>> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoryResponses> getAllCategoryResponses = categories.stream()
                .map(category -> this.modelMapperService.forResponse()
                        .map(category, GetAllCategoryResponses.class))
                .collect(Collectors.toList());

        return new DataResult<List<GetAllCategoryResponses>>(getAllCategoryResponses, true, "All categories listed.");
    }

    @Override
    public DataResult<GetByIdCategoryResponses> getById(int id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Category not found."));

        GetByIdCategoryResponses getByIdCategoryResponses = this.modelMapperService.forResponse()
                .map(category, GetByIdCategoryResponses.class);

        return new DataResult<>(getByIdCategoryResponses, true, "Category listed.");
    }

    @Override
    public Result add(CreateCategoryRequest createCategoryRequest) {

        Category category = this.modelMapperService.forRequest()
                .map(createCategoryRequest, Category.class);

        categoryRepository.save(category);

        return new SuccessResult("Category added.");
    }

    @Override
    public Result delete(DeleteCategoryRequest deleteCategoryRequest) {

        Category category = this.modelMapperService.forRequest()
                .map(deleteCategoryRequest, Category.class);
        categoryRepository.delete(category);
        return new SuccessResult("Category deleted.");
    }

    @Override
    public Result update(UpdateCategoryRequest updateCategoryRequest) {

        Category category = this.modelMapperService.forRequest()
                .map(updateCategoryRequest, Category.class);

        category.setId(updateCategoryRequest.getId());
        category.setName(updateCategoryRequest.getName());
        category.setDescription(updateCategoryRequest.getDescription());

        categoryRepository.save(category);

        return new SuccessResult("Category updated.");
    }
}
