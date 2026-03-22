package com.example.notification.service;

import com.example.common.events.NotificationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NotificationSender {
    private static final Logger log = LoggerFactory.getLogger(NotificationSender.class);

    public void send(NotificationEvent event) {
        switch (event.channel()) {
            case "EMAIL" -> sendEmail(event);
            case "SMS" -> sendSms(event);
            case "PUSH" -> sendPush(event);
            default -> log.warn("Unknown channel {} for user {}", event.channel(), event.userId());
        }
    }

    private void sendEmail(NotificationEvent event) {
        log.info("[EMAIL] to user={} template={} data={}", event.userId(), event.template(), event.data());
    }

    private void sendSms(NotificationEvent event) {
        log.info("[SMS] to user={} template={} data={}", event.userId(), event.template(), event.data());
    }

    private void sendPush(NotificationEvent event) {
        log.info("[PUSH] to user={} template={} data={}", event.userId(), event.template(), event.data());
    }
}
