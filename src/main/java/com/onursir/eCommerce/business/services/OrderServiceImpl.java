package com.onursir.eCommerce.business.services;

import com.onursir.eCommerce.Entity.Order;
import com.onursir.eCommerce.Entity.User;
import com.onursir.eCommerce.business.mappers.ModelMappersService;
import com.onursir.eCommerce.business.requests.CreateOrderRequest;
import com.onursir.eCommerce.business.responses.GetAllOrderResponse;
import com.onursir.eCommerce.business.responses.GetAllUserResponse;
import com.onursir.eCommerce.dataAccess.OrderRepository;
import com.onursir.eCommerce.dataAccess.UserRepository;
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
    public UserRepository userRepository;


    @Override
    public void addMultiple(List<CreateOrderRequest> orderRequests) {
        List<Order> orders = orderRequests.stream()
                .map(request -> modelMappersService.forRequest().map(request, Order.class))
                .collect(Collectors.toList());
        orderRepository.saveAll(orders);
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
