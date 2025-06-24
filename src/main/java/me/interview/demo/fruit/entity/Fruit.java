package me.interview.demo.fruit.entity;

import jakarta.persistence.*;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer pricePerKg;

    public Fruit() {}
    public Fruit(String name, Integer pricePerKg) {
        this.name = name;
        this.pricePerKg = pricePerKg;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getPricePerKg() { return pricePerKg; }
    public void setPricePerKg(Integer pricePerKg) { this.pricePerKg = pricePerKg; }
} 