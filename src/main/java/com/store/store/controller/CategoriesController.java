package com.store.store.controller;

import com.store.store.business.abstracts.CategoryService;
import com.store.store.dto.requests.category.UpdateCategoryRequest;
import com.store.store.dto.responses.category.GetByIdCategoryResponses;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.category.CreateCategoryRequest;
import com.store.store.dto.requests.category.DeleteCategoryRequest;
import com.store.store.dto.responses.category.GetAllCategoryResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
@CrossOrigin
public class CategoriesController {

    private CategoryService categoryService;

    @GetMapping("/getall")
    public DataResult<List<GetAllCategoryResponses>> getAll() {
        return this.categoryService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdCategoryResponses> getById(int id) {
        return this.categoryService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateCategoryRequest createCategoryRequest) {
        return this.categoryService.add(createCategoryRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteCategoryRequest deleteCategoryRequest) {
        return this.categoryService.delete(deleteCategoryRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
        return this.categoryService.update(updateCategoryRequest);
    }
}
