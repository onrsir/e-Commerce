package com.onursir.eCommerce.dataAccess;

import com.onursir.eCommerce.Entity.Product;
import com.onursir.eCommerce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findByName(String name);

    List<Product> findByProductCost(int productCost);

}
