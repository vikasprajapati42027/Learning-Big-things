package Test13;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * Lombok is a library that plugs into your IDE and build tools, 
 * spicing up your java. It saves you from writing getters, setters, 
 * toString, etc.
 * 
 * Note: To run this, you need the Lombok dependency in pom.xml.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

// Imagine these annotations are present (Lombok doesn't run without the library)
// @Data 
// @AllArgsConstructor
// @NoArgsConstructor
class User {
    private String name;
    private String email;
    
    // In a real project with Lombok, you wouldn't write these manually!
    public User(String name, String email) { this.name = name; this.email = email; }
    public String getName() { return name; }
    public String toString() { return "User(name=" + name + ")"; }
}

@Component
class Runner implements CommandLineRunner {
    @Override
    public void run(String... args) {
        User user = new User("Vikas", "vikas@lombok.com");
        System.out.println("Lombok simulated: " + user);
    }
}
