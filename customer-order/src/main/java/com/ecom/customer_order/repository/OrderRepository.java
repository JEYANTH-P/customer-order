package com.ecom.customer_order.repository;
import com.ecom.customer_order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }