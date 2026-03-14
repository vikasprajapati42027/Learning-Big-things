package com.example.ai;

import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    private final ChatClient chatClient;

    public AiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ask")
    public String askAi(@RequestParam String prompt) {
        // Calling LLM (OpenAI/Ollama) via Spring AI abstraction
        return chatClient.call(prompt);
    }
}
