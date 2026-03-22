package com.example.common.events;

public record RideStatusEvent(Long rideId, String status, String location) {
}
