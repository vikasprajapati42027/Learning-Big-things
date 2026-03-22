package com.example.notification.controller;

import com.example.common.constants.Topics;
import com.example.common.events.NotificationEvent;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/notify")
public class PublishController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PublishController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void publish(@RequestBody @Valid NotificationRequest request) {
        NotificationEvent event = new NotificationEvent(request.userId(), request.channel(), request.template(), request.data());
        kafkaTemplate.send(Topics.NOTIFICATIONS, event.userId(), event);
    }

    public record NotificationRequest(@NotBlank String userId,
                                      @NotBlank String channel,
                                      @NotBlank String template,
                                      Map<String, String> data) {
    }
}
