package com.onursir.eCommerce.business.services;

import com.onursir.eCommerce.business.requests.CreateProductRequest;
import com.onursir.eCommerce.business.responses.GetAllOrderByProductResponse;
import com.onursir.eCommerce.business.responses.GetAllProductResponse;
import com.onursir.eCommerce.business.responses.GetProductDetailResponse;

import java.util.List;

public interface ProductService {
    void add(CreateProductRequest createProductRequest);

    List<GetAllProductResponse> getAll();

    void delete(long id);

    GetProductDetailResponse getProductById(Long id);

    GetProductDetailResponse findByProductName(String name);
}
