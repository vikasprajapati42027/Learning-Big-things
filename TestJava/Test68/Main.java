package TestJava.Test68;

import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Base64 Encoding and Decoding ===\n");

        // Base64 is used to encode binary data (like images or passwords) into
        // standard ASCII printable text. It is NOT encryption (it is easily decodable),
        // but it is great for safely transmitting data over text-based protocols like HTTP.

        String originalMessage = "Secret API Key: 12345-ABCDE";
        System.out.println("Original String: " + originalMessage);

        // --- 1. Basic Encoding ---
        // Converts Strings/Bytes into Base64 format
        System.out.println("\n--- 1. Encoding ---");
        String encodedString = Base64.getEncoder().encodeToString(originalMessage.getBytes());
        System.out.println("Encoded Base64: " + encodedString);

        // --- 2. Basic Decoding ---
        // Converts Base64 back to raw Bytes, then we construct a String
        System.out.println("\n--- 2. Decoding ---");
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("Decoded String: " + decodedString);

        // --- 3. URL Safe Encoding ---
        // Standard Base64 uses '+' and '/' which break URLs.
        // URL Safe Base64 replaces them with '-' and '_'
        System.out.println("\n--- 3. URL Safe Encoding ---");
        String urlString = "https://example.com/api?user=admin&pwd=foo";
        String urlEncoded = Base64.getUrlEncoder().encodeToString(urlString.getBytes());
        System.out.println("URL Safe Encoded: " + urlEncoded);
        
        String urlDecoded = new String(Base64.getUrlDecoder().decode(urlEncoded));
        System.out.println("URL Safe Decoded: " + urlDecoded);
    }
}
