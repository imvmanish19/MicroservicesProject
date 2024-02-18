package com.manish.OrderService.service.impl;

import com.manish.OrderService.entity.Order;
import com.manish.OrderService.model.OrderRequest;
import com.manish.OrderService.repository.OrderRepository;
import com.manish.OrderService.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public long placeOrder(OrderRequest orderRequest) {
        log.info("Placing Order Request: {}", orderRequest);
        log.info("Creating Order with Status CREATED");
        Order order = Order.builder()
                .amount(orderRequest.getAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();

        order = orderRepository.save(order);

        log.info("Calling Payment Service to complete the payment");
        return order.getId();
    }
}
