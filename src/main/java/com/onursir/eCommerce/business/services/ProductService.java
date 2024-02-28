package com.onursir.eCommerce.business.services;

import com.onursir.eCommerce.business.requests.CreateProductRequest;
import com.onursir.eCommerce.business.responses.GetAllProductResponse;

import java.util.List;

public interface ProductService {
    void add(CreateProductRequest createProductRequest);

    List<GetAllProductResponse> getAll();
}
