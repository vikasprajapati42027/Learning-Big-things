package Test5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Demonstrating @Value annotation.
 * It is used for injecting single values from application.properties.
 */
@Service
public class ConfigService {

    // Injecting a simple string
    @Value("${app.name}")
    private String appName;

    // Injecting with a default value (if property is missing)
    @Value("${app.version:0.0.1-SNAPSHOT}")
    private String appVersion;

    public void printConfig() {
        System.out.println("Property Injection via @Value:");
        System.out.println("App Name: " + appName);
        System.out.println("App Version: " + appVersion);
    }
}
