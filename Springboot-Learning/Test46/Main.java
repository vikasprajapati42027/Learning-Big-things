package Test46;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Declarative HTTP Client (Feign):
 * Calling other microservices is as easy as writing an interface.
 */
@SpringBootApplication
// @EnableFeignClients
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Example Feign Client:
 * 
 * @FeignClient(name = "product-service")
 * interface ProductClient {
 *     @GetMapping("/products/{id}")
 *     Product getProduct(@PathVariable Long id);
 * }
 */
