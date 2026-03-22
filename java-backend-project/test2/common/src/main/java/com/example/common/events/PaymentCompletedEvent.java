package com.example.common.events;

import java.math.BigDecimal;

public record PaymentCompletedEvent(Long orderId, BigDecimal amount, String status) {
}
