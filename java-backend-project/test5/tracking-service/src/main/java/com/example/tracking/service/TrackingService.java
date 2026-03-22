package com.example.tracking.service;

import com.example.common.constants.Topics;
import com.example.common.events.RideAssignedEvent;
import com.example.common.events.RideStatusEvent;
import com.example.tracking.model.RideStatus;
import com.example.tracking.repository.RideStatusRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrackingService {
    private final RideStatusRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public TrackingService(RideStatusRepository repository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void start(RideAssignedEvent event) {
        RideStatus status = new RideStatus();
        status.setRideId(event.rideId());
        status.setStatus("ASSIGNED");
        status.setLocation("PICKUP_PENDING");
        repository.save(status);
        kafkaTemplate.send(Topics.RIDE_STATUS, new RideStatusEvent(event.rideId(), status.getStatus(), status.getLocation()));
    }

    public RideStatus update(Long rideId, String statusText, String location) {
        RideStatus status = repository.findById(rideId).orElseGet(() -> {
            RideStatus rs = new RideStatus(); rs.setRideId(rideId); return rs; });
        status.setStatus(statusText);
        status.setLocation(location);
        RideStatus saved = repository.save(status);
        kafkaTemplate.send(Topics.RIDE_STATUS, new RideStatusEvent(rideId, statusText, location));
        return saved;
    }

    public Optional<RideStatus> get(Long rideId) { return repository.findById(rideId); }
}
