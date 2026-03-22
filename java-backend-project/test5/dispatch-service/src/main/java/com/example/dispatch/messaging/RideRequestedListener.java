package com.example.dispatch.messaging;

import com.example.common.constants.Topics;
import com.example.common.events.RideRequestedEvent;
import com.example.dispatch.service.DispatchService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RideRequestedListener {
    private final DispatchService dispatchService;

    public RideRequestedListener(DispatchService dispatchService) {
        this.dispatchService = dispatchService;
    }

    @KafkaListener(topics = Topics.RIDE_REQUESTED, groupId = "dispatch-service")
    public void handle(RideRequestedEvent event) {
        dispatchService.assign(event);
    }
}
