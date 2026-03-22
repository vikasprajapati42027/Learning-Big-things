package com.example.notification.service;

import com.example.common.constants.Topics;
import com.example.common.events.NotificationEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {
    private final NotificationSender sender;

    public NotificationListener(NotificationSender sender) {
        this.sender = sender;
    }

    @KafkaListener(topics = Topics.NOTIFICATIONS, groupId = "notification-service")
    public void handle(NotificationEvent event) {
        sender.send(event);
    }
}
