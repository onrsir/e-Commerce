package com.onursir.eCommerce.business.responses;

import com.onursir.eCommerce.Entity.Category;
import com.onursir.eCommerce.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {
    private long id;
    private long categoryId;
    private String productName;
    private int productCost;

    List<Category> categories;

}
