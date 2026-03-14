package Test40;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * Spring Data MongoDB:
 * Using a NoSQL database with Spring Boot.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Instead of @Entity, NoSQL uses @Document.
 */
// @Document(collection = "logs")
class AppLog {
    private String id;
    private String message;
    private String level;
}

/**
 * Instead of JpaRepository, use MongoRepository.
 */
interface LogRepository extends MongoRepository<AppLog, String> {
    List<AppLog> findByLevel(String level);
}
