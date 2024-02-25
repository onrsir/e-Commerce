package com.onursir.eCommerce.business.services;

import com.onursir.eCommerce.Entity.Order;
import com.onursir.eCommerce.business.mappers.ModelMappersService;
import com.onursir.eCommerce.business.requests.CreateOrderRequest;
import com.onursir.eCommerce.business.responses.GetAllOrderResponse;
import com.onursir.eCommerce.business.responses.GetAllUserResponse;
import com.onursir.eCommerce.dataAccess.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private ModelMappersService modelMappersService;
    private OrderRepository orderRepository;

    @Override
    public void add(CreateOrderRequest createOrderRequest) {
       Order order = this.modelMappersService.forRequest().map(createOrderRequest, Order.class);
       this.orderRepository.save(order);
    }

    @Override
    public List<GetAllOrderResponse> getAll() {
        List<Order> orders  = orderRepository.findAll();
        List<GetAllOrderResponse> getAllOrders = orders.stream()
                .map(orderItem -> this.modelMappersService.forResponse()
                        .map(orderItem, GetAllOrderResponse.class)).collect(Collectors.toList());

        return getAllOrders;
    }

}
