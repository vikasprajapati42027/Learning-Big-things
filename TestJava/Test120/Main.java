package TestJava.Test120;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

// Hashing is a ONE-WAY cryptographic function. You cannot decrypt a hash.
// It is used for Storing Passwords safely, comparing file integrity, or identifying duplicate data.
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== MessageDigest (SHA-256 Hashing) ===\n");

        String password = "SuperSecretPassword123!";
        System.out.println("Original String: " + password);

        // 1. Get the SHA-256 Hash Algorithm instance
        // Avoid MD5 or SHA-1 (They are cryptographically broken/vulnerable)
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // 2. Perform the hash (Returns a raw byte array)
        byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

        // 3. Convert bytes into a readable Hex String (Standard formatting for hashes)
        String hexString = bytesToHex(encodedhash);
        
        System.out.println("\nSHA-256 Hash:");
        System.out.println(hexString);
        
        System.out.println("\nTry changing the 'p' in password to 'P' and the ENTIRE hash will look totally different! (Avalanche Effect)");
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
