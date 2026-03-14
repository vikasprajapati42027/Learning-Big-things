import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RestController
public class OrderApp {
    public static void main(String[] args) { SpringApplication.run(OrderApp.class, args); }

    @Bean public RestTemplate restTemplate() { return new RestTemplate(); }

    @GetMapping("/order")
    public String createOrder() {
        return "Order created + " + restTemplate().getForObject("http://localhost:8082/pay", String.class);
    }
}
