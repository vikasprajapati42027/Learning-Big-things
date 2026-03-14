package com.example.rsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import java.time.Duration;

@Controller
public class RSocketController {

    @MessageMapping("stock-stream")
    public Flux<String> getStockPrices() {
        // Stream of data pushed from server to client
        return Flux.interval(Duration.ofSeconds(1))
                   .map(i -> "Stock Price: $" + (100 + i));
    }
}
