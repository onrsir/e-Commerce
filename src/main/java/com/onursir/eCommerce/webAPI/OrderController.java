package com.onursir.eCommerce.webAPI;

import com.onursir.eCommerce.business.requests.CreateOrderRequest;
import com.onursir.eCommerce.business.responses.GetAllOrderResponse;
import com.onursir.eCommerce.business.responses.GetAllUserResponse;
import com.onursir.eCommerce.business.services.OrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping
    public List<GetAllOrderResponse> getAll(){
        return orderService.getAll();
    }

}
