package com.example.realtime;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.time.Duration;

@RestController
public class SseController {

    @GetMapping(value = "/stream-updates", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamData() {
        // Pushing data from server to client every second
        return Flux.interval(Duration.ofSeconds(1))
                   .map(i -> "Update #" + i + ": Stock Price is now $" + (100 + i));
    }
}
