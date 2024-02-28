package com.onursir.eCommerce.business.services;

import com.onursir.eCommerce.Entity.Product;
import com.onursir.eCommerce.business.mappers.ModelMappersService;
import com.onursir.eCommerce.business.requests.CreateProductRequest;
import com.onursir.eCommerce.business.responses.GetAllCategoryResponse;
import com.onursir.eCommerce.business.responses.GetAllOrderByProductResponse;
import com.onursir.eCommerce.business.responses.GetAllProductResponse;
import com.onursir.eCommerce.business.responses.GetProductDetailResponse;
import com.onursir.eCommerce.dataAccess.ProductRepository;
import com.onursir.eCommerce.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private ModelMappersService modelMappersService;
    private ProductRepository productRepository;
    @Override
    public void add(CreateProductRequest createProductRequest) {
        Product product = this.modelMappersService.forRequest().map(createProductRequest, Product.class);
        this.productRepository.save(product);
    }

    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products = this.productRepository.findAll();

        List<GetAllProductResponse> productResponses = products.stream()
                .map(productItem -> this.modelMappersService.forResponse()
                .map(productItem, GetAllProductResponse.class)).collect(Collectors.toList());

        return productResponses;
    }

    @Override
    public void delete(long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product == null) {
            throw new ResourceNotFoundException("Order not found with id: " + id);
        }
        this.productRepository.deleteById(id);
    }

    @Override
    public GetProductDetailResponse getProductById(Long id) {
        Product product = productRepository.findById(id)

                .orElseThrow(()-> new IllegalArgumentException("not found with id:" + id));
        return modelMappersService.forResponse().map(product,GetProductDetailResponse.class);
    }

    @Override
    public GetProductDetailResponse findByProductName(String name) {
        Product product = productRepository.findByName(name);
        if (product == null) {
            throw new EntityNotFoundException("Product not found with name: " + name);
        }
        return modelMappersService.forResponse().map(product, GetProductDetailResponse.class);
    }
}
