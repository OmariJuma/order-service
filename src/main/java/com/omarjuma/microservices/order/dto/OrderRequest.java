package com.omarjuma.microservices.order.dto;

public record OrderRequest(Long id, String orderNumber,String productName, int quantity, double price, String skuCode) {
}
