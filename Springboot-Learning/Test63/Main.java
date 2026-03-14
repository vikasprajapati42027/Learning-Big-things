package Test63;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

/**
 * RSocket:
 * A binary protocol for use on byte stream transports such as TCP, WebSockets.
 * It's native for Reactive applications.
 */
@SpringBootApplication
@Controller
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @MessageMapping("request-stream")
    public Flux<String> stream(String name) {
        return Flux.just("Hello ", name, " from RSocket Stream!");
    }
}
