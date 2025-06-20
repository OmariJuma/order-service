package com.omarjuma.microservices.order.controllers;

import com.omarjuma.microservices.order.dto.OrderRequest;
import com.omarjuma.microservices.order.models.Order;
import com.omarjuma.microservices.order.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
      Order order =orderService.placeOrder(orderRequest);
        return "Order placed successfully with ID: ";
    }
}
