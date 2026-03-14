package com.example.async;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;

@RestController
public class AsyncController {

    private final AsyncEmailService emailService;

    public AsyncController(AsyncEmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/trigger-email")
    public String trigger() throws Exception {
        // Fire and continue — don't wait for email to finish!
        CompletableFuture<String> future = emailService.sendEmail("user@example.com");
        return "Email is being sent in background. Response returned immediately!";
    }
}
