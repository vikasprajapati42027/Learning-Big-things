package com.example.common.events;

public record RideRequestedEvent(Long rideId, Long riderId, String pickup, String dropoff) {
}
