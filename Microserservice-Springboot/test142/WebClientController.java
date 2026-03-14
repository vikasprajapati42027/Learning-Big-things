package com.example.multipart;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class WebClientController {

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .build();

    @GetMapping("/remote-post/{id}")
    public Mono<String> getRemotePost(@PathVariable int id) {
        return webClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }
}
