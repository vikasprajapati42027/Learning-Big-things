import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Consumer {
    public static void main(String[] args) { SpringApplication.run(Consumer.class, args); }
    @KafkaListener(topics = "orders", groupId = "group_id")
    public void consume(String message) { System.out.println("Payload: " + message); }
}
