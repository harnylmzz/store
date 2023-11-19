package com.store.store.controller;

import com.store.store.business.abstracts.CategoryService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.category.CreateCategoryRequest;
import com.store.store.dto.requests.category.DeleteCategoryRequest;
import com.store.store.dto.responses.category.GetAllCategoryResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoriesController {

    private CategoryService categoryService;

    @GetMapping("/getall")
    public DataResult<List<GetAllCategoryResponses>> getAll() {
        return this.categoryService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateCategoryRequest createCategoryRequest) {
        return this.categoryService.add(createCategoryRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteCategoryRequest deleteCategoryRequest) {
        return this.categoryService.delete(deleteCategoryRequest);
    }
}
