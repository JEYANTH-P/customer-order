package com.ecom.customer_order.repository;

import com.ecom.customer_order.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> { }