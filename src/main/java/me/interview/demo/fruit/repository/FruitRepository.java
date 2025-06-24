package me.interview.demo.fruit.repository;

import me.interview.demo.fruit.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    Fruit findByName(String name);
} 