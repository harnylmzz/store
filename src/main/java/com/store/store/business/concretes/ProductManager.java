package com.store.store.business.concretes;

import com.store.store.business.abstracts.ProductService;
import com.store.store.config.modelmapper.ModelMapperService;
import com.store.store.core.result.DataResult;
import com.store.store.core.result.Result;
import com.store.store.core.result.SuccessResult;
import com.store.store.dto.requests.product.CreateProductRequest;
import com.store.store.dto.requests.product.DeleteProductRequest;
import com.store.store.dto.requests.product.UpdateProductRequest;
import com.store.store.dto.responses.product.GetAllProductResponses;
import com.store.store.dto.responses.product.GetByIdProductResponses;
import com.store.store.model.Product;
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

        Product product = modelMapperService.forRequest()
                .map(createProductRequest, Product.class);

        productRepository.save(product);

        return new SuccessResult("Product added.");
    }

    @Override
    public Result update(UpdateProductRequest updateProductRequest) {

        Product product = modelMapperService.forRequest()
                .map(updateProductRequest, Product.class);

        product.setId(updateProductRequest.getId());
        product.setName(updateProductRequest.getName());
        product.setPrice(updateProductRequest.getPrice());
        product.setColor(updateProductRequest.getColor());
        product.setPictureUrl(updateProductRequest.getPictureUrl());
        product.setDescription(updateProductRequest.getDescription());
        product.setDiscount(updateProductRequest.getDiscount());
        product.setDiscontinued(updateProductRequest.isDiscontinued());
        product.setReorderLevel(updateProductRequest.getReorderLevel());
        product.setSize(updateProductRequest.getSize());
        product.setUnitInOrder(updateProductRequest.getUnitInOrder());
        product.setUnitInStock(updateProductRequest.getUnitInStock());
        product.setWeight(updateProductRequest.getWeight());

        productRepository.save(product);
        return null;
    }

    @Override
    public Result delete(DeleteProductRequest deleteProductRequestL) {

        Product product = modelMapperService.forRequest()
                .map(deleteProductRequestL, Product.class);

        productRepository.delete(product);

        return new SuccessResult("Product deleted.");
    }
}
