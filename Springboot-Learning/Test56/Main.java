package Test56;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * R2DBC (Reactive Relational Database Connectivity):
 * Reactive database access for SQL databases (H2, Postgres, MySQL).
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

interface ReactiveUserRepository extends ReactiveCrudRepository<User, Long> {
    Flux<User> findByName(String name);
}

class User {
    private Long id;
    private String name;
}
