package Test82;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.function.Function;

/**
 * Spring Cloud Function:
 * Write code once and run it as an API, a background job, 
 * or a Serverless function.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public Function<String, String> reverse() {
        return input -> new StringBuilder(input).reverse().toString();
    }
}
