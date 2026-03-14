package com.example.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Duration;

@RestController
public class ReactiveController {

    // Mono: 0 or 1 item (Reactive version of Optional/Object)
    @GetMapping("/mono")
    public Mono<String> getSingle() {
        return Mono.just("Hello Reactive World!");
    }

    // Flux: 0 or N items (Reactive version of List)
    @GetMapping("/flux")
    public Flux<String> getStream() {
        return Flux.just("Apple", "Banana", "Cherry")
                   .delayElements(Duration.ofSeconds(1)); // Streams one item every second
    }
}
