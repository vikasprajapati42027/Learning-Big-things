package com.example.kafkalearning.test3.service;

import com.example.kafkalearning.test3.model.PaymentEvent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    public PaymentService(@Qualifier(\"paymentKafkaTemplate\") KafkaTemplate<String, PaymentEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(PaymentEvent event) {
        kafkaTemplate.send("payment-events", event.getPaymentId(), event);
    }
}
