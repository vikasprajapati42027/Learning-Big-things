package TestJava.Test37;

public class Main {
    static int systemCount;
    static String systemName;

    // --- 1. Static Block ---
    // Executed EXACTLY ONCE when the class is first loaded into memory by the JVM,
    // before any objects are created or any static methods (like main) are called!
    // Great for complex initializations of static variables.
    static {
        System.out.println("1. STATIC BLOCK executing...");
        systemCount = 100;
        systemName = "Backend Server";
    }

    // --- 2. Instance Initialization Block ---
    // Executed EVERY TIME an object is created, right before the constructor!
    {
        System.out.println("3. INSTANCE BLOCK executing before the constructor...");
    }

    // --- 3. Constructor ---
    public Main() {
        System.out.println("4. CONSTRUCTOR executing...");
    }

    public static void main(String[] args) {
        System.out.println("2. MAIN METHOD executing... systemName: " + systemName);

        System.out.println("\nCreating first object:");
        new Main();

        System.out.println("\nCreating second object:");
        new Main();
    }
}
