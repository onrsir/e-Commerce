package com.onursir.eCommerce.business.responses;


import com.onursir.eCommerce.Entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponse {
    private long id;
    private String userName;
    private String email;
    private List<Order> orders;
}
