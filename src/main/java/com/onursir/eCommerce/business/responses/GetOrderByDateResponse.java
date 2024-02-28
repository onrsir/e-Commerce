package com.onursir.eCommerce.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderByDateResponse {

    private long orderId;
    private BigDecimal amount;
    private LocalDateTime orderDate;
}
