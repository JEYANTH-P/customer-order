package com.ecom.customer_order.controller;

import com.ecom.customer_order.dto.CustomerDTO;
import com.ecom.customer_order.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Customer API", description = "Operations related to customers")
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @PostMapping
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) {
        return service.addCustomer(customerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }
}