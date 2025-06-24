package me.interview.demo.fruit.repository;

import me.interview.demo.fruit.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
} 