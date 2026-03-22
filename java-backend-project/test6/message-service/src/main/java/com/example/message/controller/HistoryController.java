package com.example.message.controller;

import com.example.message.model.ChatMessage;
import com.example.message.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    private final MessageService messageService;

    public HistoryController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/{roomId}")
    public List<ChatMessage> roomHistory(@PathVariable String roomId) {
        return messageService.history(roomId);
    }
}
