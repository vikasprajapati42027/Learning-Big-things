package TestJava.Test124;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

// Digital Signatures prove that a message came from a specific sender AND hasn't been tampered with.
// It is the exact OPPOSITE of Asymmetric encryption:
// You SIGN with your Private Key. The world VERIFIES with your Public Key.
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Digital Signatures (java.security.Signature) ===\n");

        String document = "I promise to pay $1000 to Bob. - Alice";
        System.out.println("Document: " + document);

        // 1. Setup Alice's Keys
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair aliceKeys = keyPairGen.generateKeyPair();
        PrivateKey alicePrivateKey = aliceKeys.getPrivate();
        PublicKey alicePublicKey = aliceKeys.getPublic();

        // 2. Alice SIGNS the document using her PRIVATE Key
        // SHA256withRSA means it hashes the document first, then encrypts the hash with RSA.
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initSign(alicePrivateKey);
        sig.update(document.getBytes()); // Feed the document into the signer
        
        byte[] signatureBytes = sig.sign();
        String signatureBase64 = Base64.getEncoder().encodeToString(signatureBytes);
        System.out.println("\nAlice's Digital Signature:");
        System.out.println(signatureBase64);

        // 3. Bob (or anyone) VERIFIES the document using Alice's PUBLIC Key
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(alicePublicKey);
        verifier.update(document.getBytes()); // Feed the SAME document into the verifier
        
        boolean isAuthentic = verifier.verify(signatureBytes);
        System.out.println("\nVerification Check 1 (Original Doc): Is Authentic? " + isAuthentic);
        
        // 4. Hacker tampers with the document
        String forgedDocument = "I promise to pay $50000 to Eve. - Alice";
        verifier.update(forgedDocument.getBytes());
        boolean isForgedAuthentic = verifier.verify(signatureBytes);
        System.out.println("Verification Check 2 (Forged Doc): Is Authentic? " + isForgedAuthentic);
    }
}
