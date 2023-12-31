package com.store.store.controller;

import com.store.store.business.abstracts.ProductService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.product.CreateProductRequest;
import com.store.store.dto.requests.product.DeleteProductRequest;
import com.store.store.dto.requests.product.UpdateProductRequest;
import com.store.store.dto.responses.product.GetAllProductResponses;
import com.store.store.dto.responses.product.GetByIdProductResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
@CrossOrigin
public class ProductsController {

    private ProductService productService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllProductResponses>> getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdProductResponses> getById(int id) {
        return this.productService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Result add(@RequestBody @Valid CreateProductRequest createProductRequest) {
        return this.productService.add(createProductRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateProductRequest updateProductRequest) {
        return this.productService.update(updateProductRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteProductRequest deleteProductRequest) {
        return this.productService.delete(deleteProductRequest);
    }

}
