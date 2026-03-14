package TestJava.Test111;

public class Main {
    // In Java 21+, Scoped Values (`ScopedValue<String> USER = ScopedValue.newInstance();`) 
    // are replacing ThreadLocal for sharing immutable data across a specific scope.
    
    // In Java 17, we still use ThreadLocal to pass data deep into methods 
    // without polluting method parameters.
    private static final ThreadLocal<String> CURRENT_USER = new ThreadLocal<>();

    public static void main(String[] args) {
        System.out.println("=== Scoped Values Concept (Java 21 Preview) ===\n");

        System.out.println("Simulating Scoped Values using Java 17 ThreadLocal:");

        // Start a request thread
        Thread requestThread = new Thread(() -> {
            try {
                // We set the "Scope" data
                System.out.println("[Thread] Setting User Context to 'AdminVikas'");
                CURRENT_USER.set("AdminVikas");
                
                // Call deep business logic without passing user as a parameter
                performBusinessLogic();
                
            } finally {
                // VERY IMPORTANT in Java 17+: You MUST clean up ThreadLocals.
                // Java 21 ScopedValues do this automatically!
                CURRENT_USER.remove();
                System.out.println("[Thread] Context cleaned up.");
            }
        });

        requestThread.start();
        
        System.out.println("\nNote on Java 21+ ScopedValues: ");
        System.out.println("ScopedValue.where(CURRENT_USER, \"AdminVikas\").run(() -> { performBusinessLogic(); });");
        System.out.println("They are faster, immutable, and clean up automatically compared to ThreadLocal!");
    }

    private static void performBusinessLogic() {
        System.out.println("[Business Layer] Retrieving User from Context: " + CURRENT_USER.get());
        saveToDatabase();
    }
    
    private static void saveToDatabase() {
        System.out.println("[Data Layer] Saving record created by: " + CURRENT_USER.get());
    }
}
