package com.example.resilience;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;

@RestController
public class ResilienceController {

    private final ResilienceService resilienceService;

    public ResilienceController(ResilienceService resilienceService) {
        this.resilienceService = resilienceService;
    }

    @GetMapping("/retry")
    public String tryMe() {
        return resilienceService.callService();
    }

    @GetMapping("/timeout")
    public CompletableFuture<String> slowMe() {
        return resilienceService.callSlowService();
    }
}
