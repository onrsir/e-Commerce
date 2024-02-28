package com.onursir.eCommerce.webAPI;


import com.onursir.eCommerce.business.requests.CreateProductRequest;
import com.onursir.eCommerce.business.responses.GetAllProductResponse;
import com.onursir.eCommerce.business.responses.GetAllUserResponse;
import com.onursir.eCommerce.business.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void add(@RequestBody CreateProductRequest createProductRequest){
        productService.add(createProductRequest);
    }

    @GetMapping
    public List<GetAllProductResponse> getAll(){
        return productService.getAll();
    }


}
