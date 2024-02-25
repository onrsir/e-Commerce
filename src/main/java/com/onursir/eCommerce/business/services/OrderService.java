package com.onursir.eCommerce.business.services;

import com.onursir.eCommerce.business.requests.CreateOrderRequest;
import com.onursir.eCommerce.business.responses.GetAllOrderResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {

     void addMultiple(List<CreateOrderRequest> orderRequests);
    List<GetAllOrderResponse> getAll();

    void delete(long id);
    void add(CreateOrderRequest orderRequests);

}
