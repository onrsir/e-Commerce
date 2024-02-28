package com.onursir.eCommerce.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

    private long id;

    private Long categoryId;
    private String productName;
    private int productCost;
}
