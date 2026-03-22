package com.example.gateway.ws;

import com.example.common.constants.Topics;
import com.example.common.events.PresenceEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class PresenceController {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PresenceController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @MessageMapping("/presence.update")
    @SendTo("/topic/presence")
    public PresenceEvent update(@Payload PresenceEvent event) {
        kafkaTemplate.send(Topics.PRESENCE_EVENTS, event);
        return event;
    }
}
