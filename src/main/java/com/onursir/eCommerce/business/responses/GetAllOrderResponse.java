package com.onursir.eCommerce.business.responses;

import com.onursir.eCommerce.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllOrderResponse {
    private long userId;
    private long orderId;
    private BigDecimal amount;
    private LocalDateTime orderDate;
}
