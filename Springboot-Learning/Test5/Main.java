package Test5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private ConfigService configService;

    @Autowired
    private MailConfig mailConfig;

    public static void main(String[] args) {
        System.out.println("Starting Test 5: External Configuration...");
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Values from @Value ---");
        configService.printConfig();
        
        System.out.println("\n--- Values from @ConfigurationProperties ---");
        mailConfig.printMailConfig();
    }
}
