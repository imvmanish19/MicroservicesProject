package com.manish.OrderService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private long productId;
    private long amount;
    private long quantity;
    private PaymentMode paymentMode;
}
