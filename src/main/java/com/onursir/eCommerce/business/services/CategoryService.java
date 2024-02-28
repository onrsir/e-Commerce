package com.onursir.eCommerce.business.services;

import com.onursir.eCommerce.business.requests.CreateCategoryRequest;
import com.onursir.eCommerce.business.requests.CreateUserRequest;
import com.onursir.eCommerce.business.responses.GetAllCategoryResponse;

import java.util.List;

public interface CategoryService {

    void add(CreateCategoryRequest createCategoryRequest);

    List<GetAllCategoryResponse> getAll();

    void delete(long id);
}
