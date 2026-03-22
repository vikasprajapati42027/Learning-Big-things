package com.example.common.events;

public record RideAssignedEvent(Long rideId, Long driverId, String driverName, String vehicle) {
}
