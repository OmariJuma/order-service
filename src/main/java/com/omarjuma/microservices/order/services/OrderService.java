package com.omarjuma.microservices.order.services;

import com.omarjuma.microservices.order.client.InventoryClient;
import com.omarjuma.microservices.order.dto.OrderRequest;
import com.omarjuma.microservices.order.models.Order;
import com.omarjuma.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public Order placeOrder(OrderRequest orderRequest){
        boolean isInstock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if(isInstock){
            log.info("Product with skuCode {} is in stock, proceeding with order placement", orderRequest.skuCode());
            var order = mapToOrder(orderRequest);
           return orderRepository.save(order);
        }
        else{
            log.error("Product with skuCode {} is not in stock", orderRequest.skuCode());
         throw new RuntimeException("Product with skuCode "+orderRequest.skuCode()+" is not in stock");
        }
    }

    private static Order mapToOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setProductName(orderRequest.productName());
        order.setQuantity(orderRequest.quantity());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        return order;
    }
}