package com.onursir.eCommerce.webAPI;


import com.onursir.eCommerce.business.requests.CreateProductRequest;
import com.onursir.eCommerce.business.responses.GetAllProductResponse;
import com.onursir.eCommerce.business.responses.GetAllUserResponse;
import com.onursir.eCommerce.business.responses.GetProductDetailResponse;
import com.onursir.eCommerce.business.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    void add(@RequestBody CreateProductRequest createProductRequest){
        productService.add(createProductRequest);
    }

    @GetMapping
    @Operation(summary = "GetAll")
    public List<GetAllProductResponse> getAll(){
        return productService.getAll();
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetProductDetailResponse> getProductDetailByIdEntity(@PathVariable Long id){
        GetProductDetailResponse productDetailResponse = productService.getProductById(id);
        return ResponseEntity.ok(productDetailResponse);
    }

    @GetMapping("/detail/{name}")
    @Operation(summary = "getByName")

    public ResponseEntity<GetProductDetailResponse> findByName(@PathVariable String name){
        try {
            GetProductDetailResponse response = productService.findByProductName(name);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }

    }




}
