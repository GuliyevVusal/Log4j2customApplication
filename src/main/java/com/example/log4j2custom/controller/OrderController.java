package com.example.log4j2custom.controller;

import com.example.log4j2custom.dto.OrderDTO;
import com.example.log4j2custom.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
        orderService.createOrder(orderDTO.getCustomerName(), orderDTO.getOrderDate());
        return ResponseEntity.ok("Order created successfully");
    }
}


