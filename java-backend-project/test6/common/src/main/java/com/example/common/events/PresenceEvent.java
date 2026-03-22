package com.example.common.events;

public record PresenceEvent(String user, String status, long timestamp) {
}
