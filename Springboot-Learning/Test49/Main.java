package Test49;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * GraphQL with Spring Boot:
 * A query language for your API. 
 * The client specifies EXACTLY what data they need.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Example Schema (schema.graphqls):
 * 
 * type Query {
 *     userById(id: ID): User
 * }
 * 
 * type User {
 *     id: ID
 *     name: String
 *     email: String
 * }
 */
