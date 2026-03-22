package com.example.presence.messaging;

import com.example.common.constants.Topics;
import com.example.common.events.PresenceEvent;
import com.example.presence.model.Presence;
import com.example.presence.service.PresenceService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PresenceListener {
    private final PresenceService presenceService;

    public PresenceListener(PresenceService presenceService) {
        this.presenceService = presenceService;
    }

    @KafkaListener(topics = Topics.PRESENCE_EVENTS, groupId = "presence-service")
    public void handle(PresenceEvent event) {
        Presence presence = new Presence();
        presence.setUsername(event.user());
        presence.setStatus(event.status());
        presence.setUpdatedAt(event.timestamp());
        presenceService.save(presence);
    }
}
