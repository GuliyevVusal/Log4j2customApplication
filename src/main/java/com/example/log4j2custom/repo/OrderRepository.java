package com.example.log4j2custom.repo;

import com.example.log4j2custom.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
