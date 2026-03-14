import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Producer {
    private final RabbitTemplate rabbit;
    public Producer(RabbitTemplate rabbit) { this.rabbit = rabbit; }
    public static void main(String[] args) { SpringApplication.run(Producer.class, args); }
    @PostMapping("/send") public void send(@RequestBody String msg) { rabbit.convertAndSend("exchange", "routingKey", msg); }
}
