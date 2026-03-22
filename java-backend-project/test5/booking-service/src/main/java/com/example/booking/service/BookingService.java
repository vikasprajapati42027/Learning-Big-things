package com.example.booking.service;

import com.example.booking.model.Ride;
import com.example.booking.repository.RideRepository;
import com.example.common.constants.Topics;
import com.example.common.events.RideRequestedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final RideRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public BookingService(RideRepository repository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Ride requestRide(Ride ride) {
        ride.setStatus("REQUESTED");
        Ride saved = repository.save(ride);
        kafkaTemplate.send(Topics.RIDE_REQUESTED, new RideRequestedEvent(saved.getId(), saved.getRiderId(), saved.getPickup(), saved.getDropoff()));
        return saved;
    }

    public List<Ride> list() { return repository.findAll(); }

    public void updateStatus(Long rideId, String status) {
        repository.findById(rideId).ifPresent(r -> { r.setStatus(status); repository.save(r); });
    }
}
