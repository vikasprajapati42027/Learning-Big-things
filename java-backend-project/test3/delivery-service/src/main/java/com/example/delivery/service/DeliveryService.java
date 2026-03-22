package com.example.delivery.service;

import com.example.common.constants.Topics;
import com.example.common.events.DeliveryStatusEvent;
import com.example.common.events.OrderPlacedEvent;
import com.example.delivery.model.Delivery;
import com.example.delivery.repository.DeliveryRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    private final DeliveryRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public DeliveryService(DeliveryRepository repository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Delivery accept(OrderPlacedEvent event) {
        Delivery delivery = new Delivery();
        delivery.setOrderId(event.orderId());
        delivery.setStatus("ASSIGNED");
        delivery.setDriverName("AutoDriver");
        Delivery saved = repository.save(delivery);
        kafkaTemplate.send(Topics.DELIVERY_STATUS, new DeliveryStatusEvent(event.orderId(), saved.getStatus()));
        return saved;
    }

    public Delivery updateStatus(Long deliveryId, String status) {
        Delivery delivery = repository.findById(deliveryId).orElseThrow();
        delivery.setStatus(status);
        Delivery saved = repository.save(delivery);
        kafkaTemplate.send(Topics.DELIVERY_STATUS, new DeliveryStatusEvent(saved.getOrderId(), saved.getStatus()));
        return saved;
    }

    public List<Delivery> list() {
        return repository.findAll();
    }
}
