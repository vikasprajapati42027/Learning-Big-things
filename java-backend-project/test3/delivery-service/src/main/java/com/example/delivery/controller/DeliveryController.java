package com.example.delivery.controller;

import com.example.delivery.model.Delivery;
import com.example.delivery.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public List<Delivery> list() {
        return deliveryService.list();
    }

    @PostMapping("/{id}/status")
    @ResponseStatus(HttpStatus.OK)
    public Delivery update(@PathVariable Long id, @RequestParam String status) {
        return deliveryService.updateStatus(id, status);
    }
}
