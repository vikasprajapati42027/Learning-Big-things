package TestJava.Test122;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

// Symmetric Encryption uses the EXACT SAME KEY to encrypt and decrypt the data.
// AES (Advanced Encryption Standard) is the global standard for this.
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Symmetric Encryption (AES / Cipher) ===\n");

        String originalMessage = "Top Secret Core Logic: Deploy immediately.";
        System.out.println("Original: " + originalMessage);

        // 1. Generate an AES Key (This key must be kept absolutely secret)
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // 256-bit AES is very strong
        SecretKey secretKey = keyGen.generateKey();

        // 2. Encrypt the Message
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        byte[] encryptedBytes = cipher.doFinal(originalMessage.getBytes());
        String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("\nEncrypted (Base64): " + encryptedBase64);

        // 3. Decrypt the Message (Requires the exact same SecretKey!)
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedBase64));
        String decryptedMessage = new String(decryptedBytes);
        
        System.out.println("\nDecrypted: " + decryptedMessage);
        
        if (originalMessage.equals(decryptedMessage)) {
            System.out.println("\nSuccess! Encryption and Decryption worked perfectly.");
        }
    }
}
