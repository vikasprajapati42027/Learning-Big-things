package TestJava.Test123;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

// Asymmetric Encryption uses a PAIR of keys (Public and Private).
// Anyone can encrypt data using the Public Key.
// ONLY the owner of the Private Key can decrypt it! 
// This is how HTTPS/SSL works!
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Asymmetric Encryption (RSA) ===\n");

        String originalMessage = "My Banking Password is: 12345";
        System.out.println("Original: " + originalMessage);

        // 1. Generate an RSA Key Pair
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048); // 2048-bit RSA is the standard
        KeyPair pair = keyPairGen.generateKeyPair();
        
        PublicKey publicKey = pair.getPublic();   // Share this with the world!
        PrivateKey privateKey = pair.getPrivate(); // Guard this with your life!

        // 2. Client Encrypts using the SERVER'S PUBLIC KEY
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        
        byte[] encryptedBytes = encryptCipher.doFinal(originalMessage.getBytes());
        System.out.println("\nEncrypted with Public Key (Nobody else can read this now):");
        System.out.println(Base64.getEncoder().encodeToString(encryptedBytes));

        // 3. Server Decrypts using its PRIVATE KEY
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        
        byte[] decryptedBytes = decryptCipher.doFinal(encryptedBytes);
        System.out.println("\nDecrypted carefully with Private Key: " + new String(decryptedBytes));
    }
}
