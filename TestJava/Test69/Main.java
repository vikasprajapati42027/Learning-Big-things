package TestJava.Test69;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== UUID Generation Tutorial ===\n");

        // UUID = Universally Unique Identifier.
        // It generates a 128-bit completely random, globally unique ID.
        // It's the standard for generating Primary Keys in modern distributed databases!
        
        // Format: 8-4-4-4-12 hex digits (e.g. 550e8400-e29b-41d4-a716-446655440000)

        System.out.println("--- 1. Generating Random UUIDs ---");
        
        // Generate a Type 4 (Pseudo-Random) UUID
        UUID userId = UUID.randomUUID();
        System.out.println("Generated User ID 1: " + userId.toString());
        
        UUID orderId = UUID.randomUUID();
        System.out.println("Generated Order ID : " + orderId.toString());

        // --- 2. Recreating a UUID from a String ---
        System.out.println("\n--- 2. Parsing UUID from String ---");
        String existingIdString = "f47ac10b-58cc-4372-a567-0e02b2c3d479";
        
        UUID parsedUuid = UUID.fromString(existingIdString);
        System.out.println("Successfully parsed UUID: " + parsedUuid);

        // A great benefit: Because it's a dedicated Object and not just a String,
        // it has built-in equality checks and hashing, making it perfect for HashMaps!
    }
}
