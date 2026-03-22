package com.example.kafkalearning.test4.consumer;

import com.example.kafkalearning.test4.config.KafkaConfig;
import com.example.kafkalearning.test4.model.OrderEvent;
import com.example.kafkalearning.test4.service.OrderProcessingException;
import com.example.kafkalearning.test4.service.OrderProcessor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {
    private static final Logger log = LoggerFactory.getLogger(OrderEventListener.class);

    private final OrderProcessor orderProcessor;

    public OrderEventListener(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    @KafkaListener(topics = KafkaConfig.ORDER_TOPIC, containerFactory = "kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<String, OrderEvent> record, Acknowledgment acknowledgment) {
        OrderEvent event = record.value();
        log.debug("Received {} at offset {}", event.getOrderId(), record.offset());
        try {
            orderProcessor.process(event);
            acknowledgment.acknowledge();
        } catch (OrderProcessingException ex) {
            log.error("Order {} rejected: {}", event.getOrderId(), ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            log.error("Unexpected failure {}", event.getOrderId(), ex);
            throw new OrderProcessingException("Processing failure", ex);
        }
    }
}
