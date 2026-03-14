package TestJava.Test213;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 213: Advanced AES (GCM mode with GCMParameterSpec) ===\n");

        System.out.println("Basic AES/ECB is extremely insecure (identical blocks encrypt to identical ciphertext).");
        System.out.println("AES/CBC needs padding. AES/GCM (Galois/Counter Mode) is the modern standard.");
        System.out.println("It provides both Encryption AND Authentication (Integrity checking).\n");

        String plaintext = "Top Secret Bank Account PIN: 1234";

        // 1. Generate AES 256 Key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();

        // 2. AES-GCM requires a unique Initialization Vector (IV) for EVERY encryption
        byte[] iv = new byte[12]; // GCM standard IV size is 12 bytes
        new SecureRandom().nextBytes(iv);

        // GCM Authentication Tag length (128 bits is standard)
        GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);

        System.out.println("Original: " + plaintext);

        // --- ENCRYPTION ---
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmSpec);
        
        byte[] cipherText = cipher.doFinal(plaintext.getBytes());
        System.out.println("Encrypted (B64): " + Base64.getEncoder().encodeToString(cipherText));

        // --- DECRYPTION ---
        Cipher decryptCipher = Cipher.getInstance("AES/GCM/NoPadding");
        // Must use the EXACT SAME key and IV (GCMParameterSpec)
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey, gcmSpec);
        
        byte[] decryptedBytes = decryptCipher.doFinal(cipherText);
        System.out.println("Decrypted: " + new String(decryptedBytes));
    }
}
