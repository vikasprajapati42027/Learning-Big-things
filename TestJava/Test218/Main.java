package TestJava.Test218;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 218: Symmetric vs Asymmetric Encryption Speed Test ===\n");

        System.out.println("Symmetric (AES) uses the same key. Asymmetric (RSA) uses Public/Private keys.");
        System.out.println("Why does HTTPS use both? Because RSA is terribly SLOW!\n");

        byte[] payload = new byte[1024]; // 1KB of data
        new java.util.Random().nextBytes(payload);

        // 1. AES Setup (Symmetric)
        KeyGenerator aesGen = KeyGenerator.getInstance("AES");
        aesGen.init(128);
        SecretKey aesKey = aesGen.generateKey();
        Cipher aesCipher = Cipher.getInstance("AES");

        // 2. RSA Setup (Asymmetric)
        KeyPairGenerator rsaGen = KeyPairGenerator.getInstance("RSA");
        rsaGen.initialize(2048);
        KeyPair rsaKey = rsaGen.generateKeyPair();
        Cipher rsaCipher = Cipher.getInstance("RSA");

        int iterations = 100;

        System.out.println("Running " + iterations + " encryptions of 1KB of data...");

        // Measure AES
        long aesStart = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            aesCipher.init(Cipher.ENCRYPT_MODE, aesKey);
            aesCipher.doFinal(payload);
        }
        long aesEnd = System.currentTimeMillis();
        System.out.println("AES (Symmetric) Total Time : " + (aesEnd - aesStart) + " ms");

        // Measure RSA (Note: RSA can't encrypt data larger than its key size natively,
        // so we'd normally encrypt an AES key with RSA, but we'll encrypt 100 bytes here to prove the point)
        byte[] tinyPayload = new byte[100]; 
        
        long rsaStart = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            rsaCipher.init(Cipher.ENCRYPT_MODE, rsaKey.getPublic());
            rsaCipher.doFinal(tinyPayload);
        }
        long rsaEnd = System.currentTimeMillis();
        System.out.println("RSA (Asymmetric) Total Time: " + (rsaEnd - rsaStart) + " ms (For much smaller data!)");

        System.out.println("\nConclusion: This is why SSL/TLS uses RSA to securely exchange an AES key,");
        System.out.println("and then uses that AES key to encrypt the actual streaming data!");
    }
}
