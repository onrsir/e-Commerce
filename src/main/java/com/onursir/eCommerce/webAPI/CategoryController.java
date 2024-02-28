package com.onursir.eCommerce.webAPI;

import com.onursir.eCommerce.business.requests.CreateCategoryRequest;
import com.onursir.eCommerce.business.responses.GetAllCategoryResponse;
import com.onursir.eCommerce.business.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Add")
    public void add(@RequestBody CreateCategoryRequest createCategoryRequest){
        categoryService.add(createCategoryRequest);
    }

    @GetMapping
    @Operation(summary = "Get All")
    public List<GetAllCategoryResponse> getAll(){
       return categoryService.getAll();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
