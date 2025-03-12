package com.ecom.customer_order.controller;

import com.ecom.customer_order.dto.OrderDTO;
import com.ecom.customer_order.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Order API", description = "Operations related to orders")
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @PostMapping
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO) {
        return service.addOrder(orderDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
    }
}