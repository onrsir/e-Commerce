package com.onursir.eCommerce.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProductDetailResponse {

    private long id;
    private String name;
    private int stock;
    private int productCost;
}
