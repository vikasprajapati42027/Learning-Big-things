package com.example.message.messaging;

import com.example.common.constants.Topics;
import com.example.common.events.ChatMessageEvent;
import com.example.message.model.ChatMessage;
import com.example.message.service.MessageService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {
    private final MessageService messageService;

    public ChatMessageListener(MessageService messageService) {
        this.messageService = messageService;
    }

    @KafkaListener(topics = Topics.CHAT_MESSAGES, groupId = "message-service")
    public void handle(ChatMessageEvent event) {
        ChatMessage msg = new ChatMessage();
        msg.setRoomId(event.roomId());
        msg.setFromUser(event.fromUser());
        msg.setContent(event.content());
        msg.setTimestamp(event.timestamp());
        messageService.save(msg);
    }
}
