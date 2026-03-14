package TestJava.Test27;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== String vs StringBuilder vs StringBuffer ===");

        // --- 1. String ---
        // Strings are IMMUTABLE (cannot be changed once created).
        // Every time you "modify" a String, Java actually creates a brand NEW String object in memory.
        System.out.println("\n--- 1. String (Immutable) ---");
        String str = "Hello";
        str = str + " World"; // Creates a new String "Hello World", old "Hello" is abandoned.
        System.out.println("String result: " + str);
        // Best use: Data that doesn't change much (e.g., username, config values).

        // --- 2. StringBuilder ---
        // StringBuilder is MUTABLE. It modifies the existing object in memory.
        // It is very FAST, making it perfect for appending lots of text in a loop.
        // However, it is NOT thread-safe.
        System.out.println("\n--- 2. StringBuilder (Mutable, Fast) ---");
        StringBuilder sbBuilder = new StringBuilder("Hello");
        sbBuilder.append(" World"); // Modifies the original object!
        System.out.println("StringBuilder result: " + sbBuilder.toString());
        // Best use: Heavy string manipulation in a single thread.

        // --- 3. StringBuffer ---
        // StringBuffer is also MUTABLE like StringBuilder.
        // The difference? It IS thread-safe (synchronized). Multiple threads can use it safely.
        // However, this synchronization makes it SLOWER than StringBuilder.
        System.out.println("\n--- 3. StringBuffer (Mutable, Thread-Safe) ---");
        StringBuffer sbBuffer = new StringBuffer("Hello");
        sbBuffer.append(" World"); // Modifies the original object safely!
        System.out.println("StringBuffer result: " + sbBuffer.toString());
        // Best use: Mutating strings across multiple threads.
    }
}
