package com.example.dispatch.service;

import com.example.common.constants.Topics;
import com.example.common.events.RideAssignedEvent;
import com.example.common.events.RideRequestedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class DispatchService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final AtomicLong driverCounter = new AtomicLong(100);

    public DispatchService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void assign(RideRequestedEvent event) {
        long driverId = driverCounter.getAndIncrement();
        RideAssignedEvent assigned = new RideAssignedEvent(event.rideId(), driverId, "Driver" + driverId, "CAR-" + driverId);
        kafkaTemplate.send(Topics.RIDE_ASSIGNED, assigned);
    }
}
