package com.example.common.events;

import java.math.BigDecimal;

public record OrderPlacedEvent(Long orderId, Long restaurantId, Long userId, String items, BigDecimal totalAmount, String address) {
}
