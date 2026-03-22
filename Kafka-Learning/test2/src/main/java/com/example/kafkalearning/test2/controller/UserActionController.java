package com.example.kafkalearning.test2.controller;

import com.example.kafkalearning.test2.model.UserAction;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actions")
public class UserActionController {

    private final KafkaTemplate<String, UserAction> kafkaTemplate;

    public UserActionController(KafkaTemplate<String, UserAction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<UserAction> publish(@RequestBody UserAction action) {
        kafkaTemplate.send("user-actions", action.getUserId(), action);
        return ResponseEntity.accepted().body(action);
    }
}
