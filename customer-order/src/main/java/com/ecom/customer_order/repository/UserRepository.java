package com.ecom.customer_order.repository;

import com.ecom.customer_order.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}