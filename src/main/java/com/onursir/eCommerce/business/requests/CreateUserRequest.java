package com.onursir.eCommerce.business.requests;

import com.onursir.eCommerce.Entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String userName;
    private String email;
}
