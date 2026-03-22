package com.example.message.service;

import com.example.message.model.ChatMessage;
import com.example.message.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final ChatMessageRepository repository;

    public MessageService(ChatMessageRepository repository) {
        this.repository = repository;
    }

    public ChatMessage save(ChatMessage msg) { return repository.save(msg); }

    public List<ChatMessage> history(String roomId) {
        return repository.findByRoomIdOrderByTimestampAsc(roomId);
    }
}
