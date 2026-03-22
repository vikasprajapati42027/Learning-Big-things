package com.example.tracking.messaging;

import com.example.common.constants.Topics;
import com.example.common.events.RideAssignedEvent;
import com.example.tracking.service.TrackingService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RideAssignedListener {
    private final TrackingService trackingService;

    public RideAssignedListener(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @KafkaListener(topics = Topics.RIDE_ASSIGNED, groupId = "tracking-service")
    public void handle(RideAssignedEvent event) {
        trackingService.startRide(event);
    }
}
