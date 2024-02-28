package com.onursir.eCommerce.dataAccess;

import com.onursir.eCommerce.Entity.Order;
import com.onursir.eCommerce.Entity.User;
import com.onursir.eCommerce.business.responses.GetOrderByUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByUser(User user);

    List<Order> findByOrderDate(LocalDateTime orderDate);
}
