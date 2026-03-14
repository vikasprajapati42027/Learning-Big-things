package Test42;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot with Messaging (Kafka/RabbitMQ):
 * Asynchronous communication between different services.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Example Producer:
 * @Service
 * class MessageProducer {
 *     @Autowired
 *     private KafkaTemplate<String, String> kafkaTemplate;
 * 
 *     public void sendMessage(String msg) {
 *         kafkaTemplate.send("my-topic", msg);
 *     }
 * }
 * 
 * Example Consumer:
 * @Component
 * class MessageConsumer {
 *     @KafkaListener(topics = "my-topic", groupId = "group-1")
 *     public void listen(String message) {
 *         System.out.println("Received: " + message);
 *     }
 * }
 */
