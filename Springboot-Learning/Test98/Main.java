package Test98;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Custom Auto-Configuration:
 * This is how Spring Boot works under the hood. 
 * You can create "Starters" that automatically configure beans 
 * only if certain conditions are met.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Configuration
@ConditionalOnClass(name = "org.postgresql.Driver")
class PostgresAutoConfig {
    @Bean
    public String dbMessage() {
        return "Postgres specific bean configured!";
    }
}
