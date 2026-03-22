package com.example.order.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
public class FoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long restaurantId;
    private Long userId;
    private String items; // simple CSV for demo
    private BigDecimal totalAmount;
    private String address;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getItems() { return items; }
    public void setItems(String items) { this.items = items; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
