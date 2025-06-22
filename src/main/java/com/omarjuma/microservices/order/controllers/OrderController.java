package com.omarjuma.microservices.order.controllers;

import com.omarjuma.microservices.order.dto.OrderRequest;
import com.omarjuma.microservices.order.models.Order;
import com.omarjuma.microservices.order.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order placeOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderService.placeOrder(orderRequest);
        log.info("Order placed successfully with ID: {}", order.getId());
        return order;
    }
}
