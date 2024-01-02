package com.store.store.business.concretes;

import com.store.store.business.abstracts.ProductService;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.ErrorResult;
import com.store.store.core.result.Result;
import com.store.store.core.result.SuccessResult;
import com.store.store.dto.requests.product.CreateProductRequest;
import com.store.store.dto.requests.product.DeleteProductRequest;
import com.store.store.dto.requests.product.UpdateProductRequest;
import com.store.store.dto.responses.product.GetAllProductResponses;
import com.store.store.dto.responses.product.GetByIdProductResponses;
import com.store.store.model.Category;
import com.store.store.model.Product;
import com.store.store.repository.CategoryRepository;
import com.store.store.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;
    private CategoryRepository categoryRepository;

    @Override
    public DataResult<List<GetAllProductResponses>> getAll() {

        List<Product> products = productRepository.findAll();
        List<GetAllProductResponses> getAllProductResponses = products.stream()
                .map(product -> modelMapperService.forResponse()
                        .map(product, GetAllProductResponses.class))
                .collect(Collectors.toList());

        return new DataResult<>(getAllProductResponses, true, "All product listed.");
    }

    @Override
    public DataResult<GetByIdProductResponses> getById(int id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found."));

        GetByIdProductResponses getByIdProductResponses = modelMapperService.forResponse()
                .map(product, GetByIdProductResponses.class);

        return new DataResult<>(getByIdProductResponses, true, "Product listed.");
    }

    @Override
    public Result add(CreateProductRequest createProductRequest) {
        Category category = categoryRepository.findById(createProductRequest.getCategoryId())
                .orElse(null);

        if (category != null) {
            Product product = new Product();
            product.setName(createProductRequest.getName());
            product.setDescription(createProductRequest.getDescription());
            product.setPrice(createProductRequest.getPrice());
            product.setUnitInStock(createProductRequest.getUnitInStock());
            product.setCategory(category);

            productRepository.save(product);

            return new SuccessResult("Product added.");
        } else {
            return new ErrorResult("Category not found.");
        }
    }

    @Override
    public Result update(UpdateProductRequest updateProductRequest) {

        Product product = modelMapperService.forRequest()
                .map(updateProductRequest, Product.class);

        product.setId(updateProductRequest.getId());
        product.setName(updateProductRequest.getName());
        product.setPrice(updateProductRequest.getPrice());
        product.setDescription(updateProductRequest.getDescription());
        product.setUnitInStock(updateProductRequest.getUnitInStock());

        productRepository.save(product);
        return new SuccessResult("Product updated.");
    }

    @Override
    public Result delete(DeleteProductRequest deleteProductRequestL) {

        Product product = modelMapperService.forRequest()
                .map(deleteProductRequestL, Product.class);

        productRepository.delete(product);

        return new SuccessResult("Product deleted.");
    }
}
