package com.onursir.eCommerce.business.responses;

import com.onursir.eCommerce.Entity.Order;
import com.onursir.eCommerce.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCategoryResponse {
    private long id;
    private String name;
    private String description;
    private List<Product> products;

}
