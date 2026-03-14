package com.example.stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreamController {

    private final MessageSender messageSender;

    public StreamController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @GetMapping("/publish")
    public String publish(@RequestParam String msg) {
        messageSender.send(msg);
        return "Message sent to Broker!";
    }
}
