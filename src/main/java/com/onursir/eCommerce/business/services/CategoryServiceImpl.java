package com.onursir.eCommerce.business.services;

import com.onursir.eCommerce.Entity.Category;
import com.onursir.eCommerce.Entity.Product;
import com.onursir.eCommerce.business.mappers.ModelMappersService;
import com.onursir.eCommerce.business.requests.CreateCategoryRequest;
import com.onursir.eCommerce.business.requests.CreateUserRequest;
import com.onursir.eCommerce.business.responses.GetAllCategoryResponse;
import com.onursir.eCommerce.dataAccess.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private ModelMappersService modelMappersService;
    private CategoryRepository categoryRepository;

    @Override
    public void add(CreateCategoryRequest createCategoryRequest) {
        Category category = this.modelMappersService.forRequest().map(createCategoryRequest, Category.class);
        this.categoryRepository.save(category);
    }

    @Override
    public List<GetAllCategoryResponse> getAll() {

        List<Category> categories = categoryRepository.findAll();

        List<GetAllCategoryResponse> categoryResponses = categories.stream()
                .map(category -> this.modelMappersService.forResponse()
                        .map(category, GetAllCategoryResponse.class)).collect(Collectors.toList());

        return categoryResponses;
    }

    @Override
    public void delete(long id) {

        categoryRepository.findById(id).orElseThrow();
        this.categoryRepository.deleteById(id);
    }
}
