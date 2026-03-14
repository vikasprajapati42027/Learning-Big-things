package TestJava.Test140;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Design Pattern: Singleton (Thread-safe) ===\n");

        System.out.println("A Singleton ensures that only ONE instance of a class exists globally.\n");

        System.out.println("--- 1. Testing Enum Singleton (The Best Way) ---");
        // Enums are natively thread-safe and protect against Reflection/Serialization attacks!
        DatabaseConnection db1 = DatabaseConnection.INSTANCE;
        DatabaseConnection db2 = DatabaseConnection.INSTANCE;
        
        db1.connect();
        
        System.out.println("Are both Enum instances the EXACT SAME object in memory? " + (db1 == db2));


        System.out.println("\n--- 2. Testing Bill Pugh Singleton (Lazy Initialization) ---");
        // This is the best traditional class-based approach. It is thread-safe without needing
        // the slow 'synchronized' keyword, thanks to the classloader mechanics!
        LegacySingleton s1 = LegacySingleton.getInstance();
        LegacySingleton s2 = LegacySingleton.getInstance();
        
        s2.doWork();
        
        System.out.println("Are both Legacy instances the EXACT SAME object in memory? " + (s1 == s2));
    }
}

// 1. The Enum Way (Joshua Bloch's recommendation)
enum DatabaseConnection {
    INSTANCE; // The solitary instance
    
    public void connect() {
        System.out.println("Enum Singleton connected to DB: jdbc:mysql://localhost:3306/prod");
    }
}

// 2. The Bill Pugh Way (Static Inner Helper Class)
class LegacySingleton {
    // Private constructor prevents direct instantiation
    private LegacySingleton() {}
    
    // The inner class is NOT loaded into memory until getInstance() is called! (Lazy loading)
    private static class SingletonHelper {
        private static final LegacySingleton INSTANCE = new LegacySingleton();
    }
    
    public static LegacySingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    public void doWork() {
        System.out.println("Legacy Singleton executing work...");
    }
}
