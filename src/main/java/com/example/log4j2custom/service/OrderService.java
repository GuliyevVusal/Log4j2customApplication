package com.example.log4j2custom.service;

import com.example.log4j2custom.entity.Order;
import com.example.log4j2custom.repo.OrderRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    private static final Logger logger = LogManager.getLogger(OrderService.class);

    private final OrderRepository orderRepository;

    private final LogService logService;

    @Transactional
    public void createOrder(String customerName, String orderDateStr) {
        try {
            Optional.ofNullable(orderDateStr)
                    .orElseThrow(() -> new IllegalArgumentException("Order date string cannot be null"));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate orderDate = LocalDate.parse(orderDateStr, formatter);
            LocalDateTime fullOrderDate = orderDate.atTime(LocalTime.now());

            Order order = new Order();
            order.setCustomerName(customerName);
            order.setOrderDate(fullOrderDate);

            orderRepository.save(order);
            logService.logOrderCreation(order, "INFO");
            logger.info("Order created: {}",order);


        } catch (DateTimeParseException ex) {
            logger.error("Error creating order", ex);
            throw new IllegalArgumentException("Invalid date format. Use yyyy-MM-dd format.");
        }
    }
}
