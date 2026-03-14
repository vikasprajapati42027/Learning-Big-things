package TestJava.Test18;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Java Records (Data Classes) Tutorial ===");

        // 1. Creating a Record object
        System.out.println("\n--- 1. Creating Records ---");
        UserRecord user1 = new UserRecord("Vikas_P", "vikas@example.com", 25);
        
        // Notice the automatically generated toString() method!
        System.out.println("User1: " + user1);

        // 2. Reading fields (Notice it's username(), not getUsername())
        System.out.println("\n--- 2. Accessing Data ---");
        System.out.println("Username: " + user1.username());
        System.out.println("Email: " + user1.email());
        System.out.println("Is Adult? " + user1.isAdult());

        // 3. Testing Equality (equals is value-based, not reference-based!)
        System.out.println("\n--- 3. Equality ---");
        UserRecord user2 = new UserRecord("VIKAS_P", "vikas@example.com", 25);
        
        // They are equal because their values are identical 
        // (remember we lowercase the username in the compact constructor)
        System.out.println("User1 equals User2? " + user1.equals(user2));

        // 4. Testing Validation (Compact Constructor)
        System.out.println("\n--- 4. Validation ---");
        try {
            UserRecord invalidUser = new UserRecord("Hacker", "bad@example.com", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Validation Error: " + e.getMessage());
        }
    }
}
