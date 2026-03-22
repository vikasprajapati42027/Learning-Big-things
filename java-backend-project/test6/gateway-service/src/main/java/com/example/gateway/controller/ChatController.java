package com.example.gateway.controller;

import com.example.common.constants.Topics;
import com.example.common.events.ChatMessageEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ChatController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/messages")
    public ChatMessageEvent send(@Payload ChatMessageEvent message) {
        kafkaTemplate.send(Topics.CHAT_MESSAGES, message);
        return message; // echo back to room via broker
    }
}
