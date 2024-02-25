package com.onursir.eCommerce.business.services;

import com.onursir.eCommerce.business.requests.CreateOrderRequest;
import com.onursir.eCommerce.business.responses.GetAllOrderResponse;

import java.util.List;

public interface OrderService {

    void add(CreateOrderRequest createOrderRequest);

    List<GetAllOrderResponse> getAll();
}
