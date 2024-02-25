package com.onursir.eCommerce.business.services;

import com.onursir.eCommerce.Entity.Order;
import com.onursir.eCommerce.Entity.User;
import com.onursir.eCommerce.business.mappers.ModelMappersService;
import com.onursir.eCommerce.business.requests.CreateOrderRequest;
import com.onursir.eCommerce.business.responses.GetAllOrderResponse;
import com.onursir.eCommerce.business.responses.GetAllUserResponse;
import com.onursir.eCommerce.dataAccess.OrderRepository;
import com.onursir.eCommerce.dataAccess.UserRepository;
import com.onursir.eCommerce.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    public void add(CreateOrderRequest orderRequests) {
        Order order = this.modelMappersService.forRequest().map(orderRequests,Order.class);
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

    @Override
    public void delete(long id) {
        Order order = this.orderRepository.findById(id).orElse(null);
        if (order == null) {
            throw new ResourceNotFoundException("Animal not found with id: " + id);
        }
        try {
            this.orderRepository.deleteById(id);
        } catch (Exception ex) {
            throw new RuntimeException("An unexpected error occurred while deleting animal with id: " + id, ex);
        }
    }

}
