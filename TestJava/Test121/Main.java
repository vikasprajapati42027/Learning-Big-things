package TestJava.Test121;

import java.security.SecureRandom;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SecureRandom vs Random Tutorial ===\n");

        System.out.println("NEVER use java.util.Random for anything security-related (passwords, tokens, cryptography)!");
        System.out.println("It uses a predictable math formula. If an attacker knows a few outputs, they can guess all future outputs.");
        
        System.out.println("\n--- 1. java.util.Random (Insecure) ---");
        Random weakRandom = new Random();
        System.out.println("Weak Random number: " + weakRandom.nextInt(1000));
        
        System.out.println("\n--- 2. java.security.SecureRandom (Secure) ---");
        // SecureRandom hooks into the Operating System's entropy pool (/dev/urandom on Linux)
        // It gathers truly random data from hardware noise, keystrokes, and mouse movements.
        SecureRandom secureRandom = new SecureRandom();
        System.out.println("Secure Random number: " + secureRandom.nextInt(1000));
        
        System.out.println("\n--- 3. Generating a Secure Token ---");
        byte[] tokenBytes = new byte[16];
        secureRandom.nextBytes(tokenBytes);
        
        // Convert the random bytes into a hex string for a token
        StringBuilder token = new StringBuilder();
        for (byte b : tokenBytes) {
            token.append(String.format("%02x", b));
        }
        
        System.out.println("Generated Secure API Token: " + token.toString());
    }
}
