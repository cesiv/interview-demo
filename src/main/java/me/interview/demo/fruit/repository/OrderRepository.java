package me.interview.demo.fruit.repository;

import me.interview.demo.fruit.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
} 