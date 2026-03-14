package TestJava.Test131;

import java.util.Iterator;
import java.util.ServiceLoader;

// 1. Define the Service Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// 2. An Implementation
class CardProcessor implements PaymentProcessor {
    public void processPayment(double amount) { System.out.println("Processing credit card: $" + amount); }
}

// Another Implementation
class CryptoProcessor implements PaymentProcessor {
    public void processPayment(double amount) { System.out.println("Processing Crypto transfer: $" + amount); }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== ServiceLoader API (Pluggable Architectures) ===\n");

        // The ServiceLoader is the built-in dependency injection / plugin system of Java!
        // It looks for a specific file in `META-INF/services/` to know which implementations to load.

        // Setup the mock META-INF/services directory
        java.nio.file.Path serviceDir = java.nio.file.Paths.get("TestJava/Test131/META-INF/services");
        java.nio.file.Files.createDirectories(serviceDir);
        
        java.nio.file.Path serviceFile = serviceDir.resolve("TestJava.Test131.PaymentProcessor");
        // We register both implementations
        java.nio.file.Files.writeString(serviceFile, 
            "TestJava.Test131.CardProcessor\nTestJava.Test131.CryptoProcessor");

        System.out.println("Mocked Plugin Registration. Loading Services natively...\n");

        // 3. Load all registered implementations dynamically!
        // We use a custom URLClassLoader for this demo to point to our local META-INF
        java.net.URL[] urls = { new java.io.File("TestJava/Test131/").toURI().toURL() };
        java.net.URLClassLoader mockLoader = new java.net.URLClassLoader(urls);
        
        ServiceLoader<PaymentProcessor> loader = ServiceLoader.load(PaymentProcessor.class, mockLoader);
        
        // Loop through all discovered plugins and run them
        int count = 0;
        for (PaymentProcessor processor : loader) {
            System.out.println("Found Plugin: " + processor.getClass().getSimpleName());
            processor.processPayment(150.00);
            count++;
        }
        
        if (count == 0) System.out.println("No plugins found (check classpath/META-INF).");
        
        // Clean up
        java.nio.file.Files.delete(serviceFile);
        java.nio.file.Files.delete(serviceDir);
    }
}
