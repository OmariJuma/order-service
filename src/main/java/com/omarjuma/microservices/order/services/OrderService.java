package com.omarjuma.microservices.order.services;

import com.omarjuma.microservices.order.dto.OrderRequest;
import com.omarjuma.microservices.order.models.Order;
import com.omarjuma.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setProductName(orderRequest.productName());
        order.setQuantity(orderRequest.quantity());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        return orderRepository.save(order);

    }
}
