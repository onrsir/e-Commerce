package com.onursir.eCommerce.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private long id;
    private long userId;
    private BigDecimal amount;
    private LocalDateTime orderDate;

}
