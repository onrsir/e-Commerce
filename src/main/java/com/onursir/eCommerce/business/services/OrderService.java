package com.onursir.eCommerce.business.services;

import com.onursir.eCommerce.Entity.Order;
import com.onursir.eCommerce.Entity.User;
import com.onursir.eCommerce.business.requests.CreateOrderRequest;
import com.onursir.eCommerce.business.responses.GetAllOrderResponse;
import com.onursir.eCommerce.business.responses.GetOrderByDateResponse;
import com.onursir.eCommerce.business.responses.GetOrderByUser;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

     void addMultiple(List<CreateOrderRequest> orderRequests);
    List<GetAllOrderResponse> getAll();

    void delete(long id);
    void add(CreateOrderRequest orderRequests);

    List<GetOrderByUser> findOrderByUser(User user);

    List<GetOrderByDateResponse> findByOrderDate(LocalDateTime orderDate);

}
