package com.example.order.repository;

import com.example.order.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}
