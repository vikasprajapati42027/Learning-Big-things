package com.example.common.events;

public record DeliveryStatusEvent(Long orderId, String status) {
}
