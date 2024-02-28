package com.onursir.eCommerce.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderByUser {

    private long id;
    private BigDecimal amount;
    private LocalDateTime orderDate;
}
