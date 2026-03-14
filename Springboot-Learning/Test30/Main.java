package Test30;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Consuming External APIs:
 * RestTemplate is the classic way to make HTTP calls in Spring.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

@Component
class ApiClient implements CommandLineRunner {
    private final RestTemplate restTemplate;
    public ApiClient(RestTemplate restTemplate) { this.restTemplate = restTemplate; }

    @Override
    public void run(String... args) {
        System.out.println("ApiClient: Fetching data from external API...");
        // String quote = restTemplate.getForObject("https://api.kanye.rest", String.class);
        // System.out.println("External Result: " + quote);
    }
}
