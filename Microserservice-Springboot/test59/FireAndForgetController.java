package com.example.rsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class FireAndForgetController {

    @MessageMapping("log-event")
    public Mono<Void> logEvent(String event) {
        // Don't send anything back, just process
        System.out.println("Received Fire-and-Forget Event: " + event);
        return Mono.empty();
    }
}
