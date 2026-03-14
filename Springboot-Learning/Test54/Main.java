package Test54;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Spring WebFlux:
 * Non-blocking, reactive web framework. 
 * Instead of "One Thread per Request", it uses "Event Loops".
 */
@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/stream")
    public Flux<String> streamData() {
        return Flux.just("Data 1", "Data 2", "Data 3").log();
    }
}
