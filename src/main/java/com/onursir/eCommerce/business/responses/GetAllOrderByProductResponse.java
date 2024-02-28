package com.onursir.eCommerce.business.responses;

import com.onursir.eCommerce.Entity.Order;
import com.onursir.eCommerce.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllOrderByProductResponse {
    private long id;
    private long categoryId;
    private String productName;
    private int productCost;
    private List<Order> orders;

}
