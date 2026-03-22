package com.example.kafkalearning.test3.controller;

import com.example.kafkalearning.test3.model.PaymentEvent;
import com.example.kafkalearning.test3.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PaymentEvent> publish(@RequestBody PaymentEvent payment) {
        service.publish(payment);
        return ResponseEntity.accepted().body(payment);
    }
}
