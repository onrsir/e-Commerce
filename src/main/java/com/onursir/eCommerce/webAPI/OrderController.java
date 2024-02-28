package com.onursir.eCommerce.webAPI;

import com.onursir.eCommerce.Entity.User;
import com.onursir.eCommerce.business.requests.CreateOrderRequest;
import com.onursir.eCommerce.business.responses.GetAllOrderResponse;
import com.onursir.eCommerce.business.responses.GetAllUserResponse;
import com.onursir.eCommerce.business.responses.GetOrderByDateResponse;
import com.onursir.eCommerce.business.responses.GetOrderByUser;
import com.onursir.eCommerce.business.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping("/add-multiple")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMultiple(@RequestBody List<CreateOrderRequest> orderRequests) {
        orderService.addMultiple(orderRequests);
    }

/*
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    public void delete(@PathVariable long id) {
        this.orderService.delete(id);
    }
*/

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    @Operation(summary = "Get All")
    public List<GetAllOrderResponse> getAll(){
        return orderService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public void add(@RequestBody CreateOrderRequest orders) {
        orderService.add(orders);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GetOrderByUser>> findOrderByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        List<GetOrderByUser> orders = orderService.findOrderByUser(user);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<GetOrderByDateResponse>> getOrdersByDate(@RequestParam("orderDate") LocalDateTime orderDate) {
        List<GetOrderByDateResponse> orders = orderService.findByOrderDate(orderDate);
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(orders);
        }
    }


}
