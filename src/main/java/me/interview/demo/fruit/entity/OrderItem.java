package me.interview.demo.fruit.entity;

import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "fruit_id")
    private Fruit fruit;

    private Integer quantity;
    private Integer subtotal;

    public OrderItem() {}
    public OrderItem(Order order, Fruit fruit, Integer quantity, Integer subtotal) {
        this.order = order;
        this.fruit = fruit;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
    public Fruit getFruit() { return fruit; }
    public void setFruit(Fruit fruit) { this.fruit = fruit; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Integer getSubtotal() { return subtotal; }
    public void setSubtotal(Integer subtotal) { this.subtotal = subtotal; }
} 