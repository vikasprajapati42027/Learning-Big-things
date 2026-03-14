package Test71;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring AI:
 * A project that aims to simplify the integration 
 * of Artificial Intelligence into Spring applications.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Test 71: Spring AI Intro...");
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Supported Models:
 * - OpenAI (ChatGPT)
 * - Azure OpenAI
 * - Anthropic (Claude)
 * - Ollama (Local models)
 * - Hugging Face
 */
