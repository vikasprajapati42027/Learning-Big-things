package Test55;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Mono and Flux are the building blocks of Project Reactor.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Component
class ReactorRunner implements CommandLineRunner {
    @Override
    public void run(String... args) {
        // Mono: 0 or 1 item
        Mono<String> m = Mono.just("Single Value");
        m.subscribe(System.out::println);

        // Flux: 0 to N items
        Flux<Integer> f = Flux.range(1, 5)
                            .map(i -> i * 10);
        f.subscribe(val -> System.out.println("Flux item: " + val));
    }
}
