package com.example.kafkalearning.test3.consumer;

import com.example.kafkalearning.test3.config.KafkaTopicConfig;
import com.example.kafkalearning.test3.model.PaymentEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventListener {
    private static final Logger log = LoggerFactory.getLogger(PaymentEventListener.class);

    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    public PaymentEventListener(@Qualifier(\"paymentKafkaTemplate\") KafkaTemplate<String, PaymentEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = KafkaTopicConfig.PAYMENTS_TOPIC, groupId = "payment-processors")
    public void listen(ConsumerRecord<String, PaymentEvent> record) {
        PaymentEvent event = record.value();
        log.info("Received payment {} from partition {} offset {}", event.getPaymentId(), record.partition(), record.offset());

        if (event.getAmount() < 0 || event.getAmount() > 2000) {
            log.warn("Rerouting {} to dead-letter topic", event.getPaymentId());
            kafkaTemplate.send(KafkaTopicConfig.DLT_TOPIC, event.getPaymentId(), event);
            return;
        }

        log.info("Accepted {} amount {} status {}", event.getPaymentId(), event.getAmount(), event.getStatus());
    }
}
