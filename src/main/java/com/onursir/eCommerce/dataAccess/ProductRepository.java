package com.onursir.eCommerce.dataAccess;

import com.onursir.eCommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
