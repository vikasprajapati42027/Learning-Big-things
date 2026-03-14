package Test72;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * Spring AI with Ollama:
 * Running AI models locally (no API keys, no internet required!).
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Example usage:
 * 
 * @RestController
 * class AiController {
 *     private final ChatClient chatClient;
 *     public AiController(ChatClient chatClient) { this.chatClient = chatClient; }
 * 
 *     @GetMapping("/ask")
 *     public String ask(@RequestParam String question) {
 *         return chatClient.call(question);
 *     }
 * }
 */
@Component
class MockRunner implements CommandLineRunner {
    @Override
    public void run(String... args) {
        System.out.println("Test 72: Mocking AI call (requires Ollama to be running).");
    }
}
