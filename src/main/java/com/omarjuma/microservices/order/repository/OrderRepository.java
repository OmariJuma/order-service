package com.omarjuma.microservices.order.repository;

import com.omarjuma.microservices.order.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
