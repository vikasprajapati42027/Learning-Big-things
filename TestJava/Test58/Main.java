package TestJava.Test58;

// The 'assert' keyword is used for debugging purposes to verify conditions in your code.
// If the condition is false, Java throws an AssertionError.
// IMPORTTANT: Asserts are DISABLED by default in the JVM! 
// They must be enabled by passing the '-ea' (enable assertions) flag when running the program:
//   java -ea TestJava.Test58.Main
public class Main {
    public static void main(String[] args) {
        System.out.println("=== The 'assert' Keyword Tutorial ===\n");

        int age = 15;
        System.out.println("Testing age: " + age);

        // --- 1. Basic Assertion ---
        // Syntax: assert boolean_condition;
        // Commenting this out because if -ea is missing, it silently passes anyway.
        // assert age >= 18;
        
        System.out.println("\n(To see asserts fail, you must run this class with 'java -ea TestJava.Test58.Main')");

        // --- 2. Assertion with Message ---
        // Syntax: assert boolean_condition : "Error Message";
        
        int speed = 120;
        int speedLimit = 100;
        
        try {
            // We use standard Exception throwing as an alternative to assert for production logic,
            // but this is how an assert with a message looks:
            assert speed <= speedLimit : "Speeding Violation Detected! Speed: " + speed;
            System.out.println("Speed is within limits.");
            
        } catch (AssertionError e) {
            // This catch ONLY triggers if you ran Java with '-ea'
            System.out.println("Assertion Error Caught: " + e.getMessage());
        }

        // --- Summary Reminder ---
        // DO NOT use asserts to check input from users! (Because they can be disabled in production).
        // Asserts are ONLY meant to check conditions that the developer assumes are ALWAYS true 
        // (internal program logic bugs).
        System.out.println("\nAsserts finished processing.");
    }
}
