package com.example.functions;

import java.util.function.Function;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Test 48: Serverless Microservices (Spring Cloud Function).
 * Deploy only logic, not servers.
 */
@SpringBootApplication
public class ServerlessApplication {

    public static void main(String[] args) { SpringApplication.run(ServerlessApplication.class, args); }

    @Bean
    public Function<String, String> uppercase() {
        return value -> value.toUpperCase();
    }
}
/**
 * You can deploy this single 'Function' to AWS Lambda 
 * or Azure Functions. You pay only when the code runs!
 */
