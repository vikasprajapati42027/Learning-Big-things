package Test70;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Spring Boot with Neo4j:
 * A Graph Database. Instead of Tables, it uses Nodes and Relationships.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Use Case:
 * Social networks (Friend of Friend), Recommendation Engines, 
 * and Fraud Detection.
 */
interface PersonRepository extends Neo4jRepository<Person, Long> {
}

class Person {
    private Long id;
    private String name;
    // @Relationship(type = "FRIEND_OF")
    // private List<Person> friends;
}
