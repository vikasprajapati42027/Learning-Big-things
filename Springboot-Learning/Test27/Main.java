package Test27;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Content Negotiation:
 * Allowing the client to request data in different formats (JSON, XML).
 */
@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping(value = "/data", produces = {"application/json", "application/xml"})
    public UserData getData() {
        return new UserData("Vikas", 25);
    }
}

class UserData {
    private String name;
    private int age;
    public UserData(String name, int age) { this.name = name; this.age = age; }
    public String getName() { return name; }
    public int getAge() { return age; }
}
