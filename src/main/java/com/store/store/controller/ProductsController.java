package com.store.store.controller;

import com.store.store.business.abstracts.ProductService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.dto.requests.product.CreateProductRequest;
import com.store.store.dto.requests.product.DeleteProductRequest;
import com.store.store.dto.requests.product.UpdateProductRequest;
import com.store.store.dto.responses.product.GetAllProductResponses;
import com.store.store.dto.responses.product.GetByIdProductResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
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
    Result add(CreateProductRequest createProductRequest) {
        return this.productService.add(createProductRequest);
    }

    @PutMapping("/update")
    Result update(UpdateProductRequest updateProductRequest) {
        return this.productService.update(updateProductRequest);
    }

    @DeleteMapping("/delete")
    Result delete(DeleteProductRequest deleteProductRequest) {
        return this.productService.delete(deleteProductRequest);
    }

}
