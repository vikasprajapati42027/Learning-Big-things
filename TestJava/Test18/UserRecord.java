package TestJava.Test18;

/**
 * A Java Record (introduced as a preview in Java 14, standard in Java 16).
 * This single line automatically generates:
 * - A constructor with all fields
 * - private final fields (immutable data)
 * - Getter methods (e.g., username(), NOT getUsername())
 * - equals()
 * - hashCode()
 * - toString()
 * 
 * It's the ultimate boilerplate killer for plain data objects!
 */
public record UserRecord(String username, String email, int age) {
    
    // We can still add custom validations in a "Compact Constructor"
    public UserRecord {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative: " + age);
        }
        
        // We can also modify the data before it's saved to the immutable fields
        username = username.toLowerCase();
    }
    
    // We can add custom methods too!
    public boolean isAdult() {
        return age >= 18;
    }
}
