package com.ecom.customer_order.service;

import com.ecom.customer_order.dto.OrderDTO;
import com.ecom.customer_order.exception.ResourceNotFoundException;
import com.ecom.customer_order.model.Order;
import com.ecom.customer_order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<OrderDTO> getAllOrders() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        return convertToDTO(order);
    }

    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order order = convertToEntity(orderDTO);
        Order savedOrder = repository.save(order);
        return convertToDTO(savedOrder);
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }

    private OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setProduct(order.getProduct());
        orderDTO.setQuantity(order.getQuantity());
        return orderDTO;
    }

    private Order convertToEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setProduct(orderDTO.getProduct());
        order.setQuantity(orderDTO.getQuantity());
        return order;
    }
}