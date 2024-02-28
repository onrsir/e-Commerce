package com.onursir.eCommerce.webAPI;

import com.onursir.eCommerce.business.requests.CreateCategoryRequest;
import com.onursir.eCommerce.business.responses.GetAllCategoryResponse;
import com.onursir.eCommerce.business.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateCategoryRequest createCategoryRequest){
        categoryService.add(createCategoryRequest);
    }

    @GetMapping
    public List<GetAllCategoryResponse> getAll(){
       return categoryService.getAll();
    }
}
