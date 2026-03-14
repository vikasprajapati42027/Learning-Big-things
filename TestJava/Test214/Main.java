package TestJava.Test214;

import javax.crypto.KeyAgreement;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 214: Diffie-Hellman Key Exchange Concept ===\n");

        System.out.println("How do Alice and Bob agree on a secret AES key over the internet");
        System.out.println("without anyone eavesdropping? Diffie-Hellman Math Magic!\n");

        System.out.println("1. Alice and Bob generate their OWN Private/Public Key PAIRS.");
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
        kpg.initialize(2048);
        
        KeyPair aliceKeyPair = kpg.generateKeyPair();
        KeyPair bobKeyPair = kpg.generateKeyPair();

        System.out.println("2. They exchange PUBLIC keys over the open dangerous internet.");
        // Hacker sees aliceKeyPair.getPublic() and bobKeyPair.getPublic()

        System.out.println("3. Alice combines her PRIVATE key with Bob's PUBLIC key.");
        KeyAgreement aliceKeyAgree = KeyAgreement.getInstance("DH");
        aliceKeyAgree.init(aliceKeyPair.getPrivate());
        aliceKeyAgree.doPhase(bobKeyPair.getPublic(), true);
        byte[] aliceSharedSecret = aliceKeyAgree.generateSecret();

        System.out.println("4. Bob combines his PRIVATE key with Alice's PUBLIC key.");
        KeyAgreement bobKeyAgree = KeyAgreement.getInstance("DH");
        bobKeyAgree.init(bobKeyPair.getPrivate());
        bobKeyAgree.doPhase(aliceKeyPair.getPublic(), true);
        byte[] bobSharedSecret = bobKeyAgree.generateSecret();

        System.out.println("\nWait, did they calculate the exact same bytes??");
        System.out.println("Alice's Secret Bytes length: " + aliceSharedSecret.length);
        System.out.println("Bob's Secret Bytes length:   " + bobSharedSecret.length);
        
        boolean match = java.util.Arrays.equals(aliceSharedSecret, bobSharedSecret);
        System.out.println("DO THEY MATCH? -> " + match);
        
        System.out.println("\nHacker couldn't calculate this because they don't have ANY of the Private keys!");
        System.out.println("Alice and Bob now use these identical bytes as an AES Key!");
    }
}
