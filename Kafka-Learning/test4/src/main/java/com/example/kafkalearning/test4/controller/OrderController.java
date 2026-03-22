package com.example.kafkalearning.test4.controller;

import com.example.kafkalearning.test4.model.OrderEvent;
import com.example.kafkalearning.test4.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/orders")
@Validated
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderEvent> publishOrder(@Valid @RequestBody OrderEvent orderEvent) {
        if (orderEvent.getCreatedAt() == null) {
            orderEvent.setCreatedAt(Instant.now());
        }
        orderService.publish(orderEvent);
        return ResponseEntity.accepted().body(orderEvent);
    }
}
