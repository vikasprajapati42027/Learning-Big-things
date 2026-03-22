package com.example.order.controller;

import com.example.order.model.FoodOrder;
import com.example.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FoodOrder place(@RequestBody FoodOrder order) {
        return orderService.place(order);
    }

    @GetMapping
    public List<FoodOrder> list() {
        return orderService.list();
    }
}
