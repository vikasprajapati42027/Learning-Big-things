package com.example.common.events;

import java.util.Map;

public record NotificationEvent(String userId,
                                String channel, // EMAIL | SMS | PUSH
                                String template,
                                Map<String, String> data) {
}
