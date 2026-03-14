package Test74;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Prompt Templates:
 * Managing complex instructions for the AI.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Example Template:
 * "You are a travel agent. Based on the user's budget of {budget}, 
 * suggest 3 destinations in {country}."
 */
