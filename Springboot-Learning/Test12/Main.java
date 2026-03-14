package Test12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Although application.properties is the default, 
 * you can load properties from any custom file using @PropertySource.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Configuration
@PropertySource("classpath:custom.properties")
class CustomConfig {}

@Component
class Runner implements CommandLineRunner {
    @Value("${custom.message:File not found}")
    private String message;

    @Override
    public void run(String... args) {
        System.out.println("Custom Property: " + message);
    }
}
