package Test7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Test 7: REST Inputs...");
        System.out.println("Try these URLs:");
        System.out.println("1. http://localhost:8080/api/user/101 (@PathVariable)");
        System.out.println("2. http://localhost:8080/api/search?query=laptop (@RequestParam)");
        SpringApplication.run(Main.class, args);
    }
}
