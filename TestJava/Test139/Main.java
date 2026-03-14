package TestJava.Test139;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Java Platform Module System (JPMS / Jigsaw) ===\n");
        
        System.out.println("In Java 9+, code can be organized into 'Modules' not just packages.");
        System.out.println("Before modules, ALL public classes in your .jar were visible to the whole world.");
        System.out.println("Modules provide TRUE encapsulation!\n");

        System.out.println("To use it, you create a `module-info.java` file in the root of your source:\n");
        
        String dummyModuleInfo = """
            module com.mycompany.payment {
                // 1. WHAT API DOES THIS MODULE EXPORT?
                // Only classes in this specific package are visible to other modules!
                // All other 'public' classes in other packages stay hidden internally.
                exports com.mycompany.payment.api;
                
                // 2. WHAT DOES THIS MODULE DEPEND ON?
                // We clearly define what external modules we need.
                requires java.sql;       // Requires JDBC functionality
                requires java.net.http;  // Requires the HttpClient module
                
                // 3. TRANSITIVE DEPENDENCIES
                // Anyone who imports us automatically gets the logging API too!
                requires transitive java.logging;
                
                // 4. REFLECTION RESTRICTIONS (Security!)
                // Frameworks like Spring/Hibernate cannot use Reflection to bypass 'private' variables
                // unless we EXPLICITLY grant them permission to open specific packages!
                opens com.mycompany.payment.entities to spring.core;
                
                // 5. SERVICES
                uses com.mycompany.payment.api.PaymentProcessor;
                provides com.mycompany.payment.api.PaymentProcessor with com.mycompany.payment.internal.StripeProcessor;
            }
            """;
            
        System.out.println(dummyModuleInfo);
        
        System.out.println("Why is this useful?");
        System.out.println("1. Security: Hackers/Libraries cannot magically access internal helper objects via Reflection.");
        System.out.println("2. Smaller Images: Using `jlink`, you can strip out parts of the JDK you don't use.");
        System.out.println("   (Your runtime could be 30MB instead of 150MB!)");
    }
}
