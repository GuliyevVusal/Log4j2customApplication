package com.example.log4j2custom.service;

import com.example.log4j2custom.entity.Log;
import com.example.log4j2custom.entity.Order;
import com.example.log4j2custom.repo.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@AllArgsConstructor
public class LogService {

    private final LogRepository logRepository;


    public void logOrderCreation(Order order,String logLevel) {
        Log log = new Log();
        log.setEventDate(Timestamp.valueOf(order.getOrderDate()));
        log.setLevel(logLevel);
        log.setLogger("OrderService");
        log.setMessage("Order created with ID: " + order.getId());
        logRepository.save(log);
    }
}
