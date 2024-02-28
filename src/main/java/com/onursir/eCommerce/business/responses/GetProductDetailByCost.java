package com.onursir.eCommerce.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductDetailByCost {
    private long id;
    private long categoryId;
    private String name;
    private String productName;
    private int productCost;

}
