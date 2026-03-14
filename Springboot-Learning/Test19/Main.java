package Test19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

/**
 * Method Level Security:
 * Instead of configuring security globally by URL, 
 * you can secure specific methods in your @Service classes.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Service
class AdminService {

    // (Simulated annotation)
    // @PreAuthorize("hasRole('ADMIN')")
    public void deleteEverything() {
        System.out.println("Deleting data... only an ADMIN could trigger this.");
    }

    // @PreAuthorize("isAuthenticated()")
    public String getInfo() {
        return "User data...";
    }
}
