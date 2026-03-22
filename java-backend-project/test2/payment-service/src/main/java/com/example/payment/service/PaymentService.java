package com.example.payment.service;

import com.example.common.constants.Topics;
import com.example.common.events.OrderCreatedEvent;
import com.example.common.events.PaymentCompletedEvent;
import com.example.payment.model.Payment;
import com.example.payment.repository.PaymentRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PaymentService(PaymentRepository repository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Payment handle(OrderCreatedEvent event) {
        Payment payment = new Payment();
        payment.setOrderId(event.orderId());
        payment.setAmount(event.amount());
        payment.setStatus("COMPLETED");
        Payment saved = repository.save(payment);
        PaymentCompletedEvent completed = new PaymentCompletedEvent(event.orderId(), event.amount(), saved.getStatus());
        kafkaTemplate.send(Topics.PAYMENTS_COMPLETED, completed);
        return saved;
    }

    public List<Payment> list() {
        return repository.findAll();
    }
}
