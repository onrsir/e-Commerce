package com.onursir.eCommerce.business.services;

import com.onursir.eCommerce.Entity.Product;
import com.onursir.eCommerce.business.mappers.ModelMappersService;
import com.onursir.eCommerce.business.requests.CreateProductRequest;
import com.onursir.eCommerce.business.responses.GetAllProductResponse;
import com.onursir.eCommerce.dataAccess.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .map(product -> this.modelMappersService.forResponse()
                .map(product, GetAllProductResponse.class)).collect(Collectors.toList());

        return productResponses;
    }
}
