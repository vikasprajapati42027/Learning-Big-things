package Test4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    /**
     * Even though MyCustomObject has no annotations, 
     * Spring can inject it because we registered it in ProjectConfig.
     */
    @Autowired
    private MyCustomObject myCustomObject;

    public static void main(String[] args) {
        System.out.println("Starting Test4: Custom Configuration...");
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Verifying Custom Bean Registration:");
        myCustomObject.displayMessage();
    }
}
