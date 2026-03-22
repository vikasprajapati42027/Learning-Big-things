package com.example.order.service;

import com.example.common.constants.Topics;
import com.example.common.events.OrderPlacedEvent;
import com.example.order.model.FoodOrder;
import com.example.order.repository.FoodOrderRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final FoodOrderRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderService(FoodOrderRepository repository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public FoodOrder place(FoodOrder order) {
        order.setStatus("PLACED");
        FoodOrder saved = repository.save(order);
        OrderPlacedEvent event = new OrderPlacedEvent(saved.getId(), saved.getRestaurantId(), saved.getUserId(), saved.getItems(), saved.getTotalAmount(), saved.getAddress());
        kafkaTemplate.send(Topics.ORDERS_PLACED, event);
        return saved;
    }

    public List<FoodOrder> list() {
        return repository.findAll();
    }

    public void updateStatus(Long orderId, String status) {
        repository.findById(orderId).ifPresent(o -> {
            o.setStatus(status);
            repository.save(o);
        });
    }
}
