import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class PaymentApp {
    public static void main(String[] args) { SpringApplication.run(PaymentApp.class, args); }
    @GetMapping("/pay") public String pay() { return "Payment Successful"; }
}
