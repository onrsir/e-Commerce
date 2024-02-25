package com.onursir.eCommerce.dataAccess;

import com.onursir.eCommerce.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
