package TestJava.Test215;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 215: PBKDF2 Password Hashing (Salt + Iterations) ===\n");

        System.out.println("NEVER store plain passwords. NEVER use flat MD5/SHA-256 for passwords.");
        System.out.println("Hackers use Rainbow Tables. You must add Salt AND slow down the hash (Key Stretching).\n");
        System.out.println("PBKDF2 (Password-Based Key Derivation Function 2) does exactly this!\n");

        String password = "mySup3rSecr3tPassword";
        System.out.println("Original Password: " + password);

        // 1. Generate a random Salt (Should be stored in DB alongside hash)
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        String saltB64 = Base64.getEncoder().encodeToString(salt);

        // 2. Set Iterations (Higher is slower, but safer against GPU brute force)
        int iterations = 100_000; 
        int keyLength = 256; // 256 bits output

        System.out.println("Hashing with " + iterations + " iterations. This might take a millisecond...");
        long start = System.currentTimeMillis();

        // 3. PBKDF2 Hashing
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        
        byte[] hash = factory.generateSecret(spec).getEncoded();
        long end = System.currentTimeMillis();

        String hashB64 = Base64.getEncoder().encodeToString(hash);
        
        System.out.println("Time taken: " + (end - start) + "ms");
        
        System.out.println("\nData to store in Database:");
        System.out.println("Salt: " + saltB64);
        System.out.println("Hash: " + hashB64);
        
        System.out.println("\nWhen user logs in, retrieve the salt, run the exact same process");
        System.out.println("with their entered password, and see if the final Hash matches!");
    }
}
