package TestJava.Test212;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 212: JWT (JSON Web Token) Structure & Signing ===\n");

        System.out.println("A JWT has 3 parts: Header.Payload.Signature (All Base64URLEncoded)\n");

        String secretKey = "MySuperSecretKeyForJwtSigningMustBeVeryLong";

        // 1. The Header (Algorithm & Type)
        String headerJson = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
        String headerB64 = Base64.getUrlEncoder().withoutPadding().encodeToString(headerJson.getBytes());

        // 2. The Payload (The Claims - User Data)
        String payloadJson = "{\"sub\":\"1234567890\",\"name\":\"Vikas\",\"admin\":true}";
        String payloadB64 = Base64.getUrlEncoder().withoutPadding().encodeToString(payloadJson.getBytes());

        // 3. The Signature (Proves the token wasn't tampered with!)
        String dataToSign = headerB64 + "." + payloadB64;
        
        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        hmacSha256.init(secretKeySpec);
        
        byte[] signatureBytes = hmacSha256.doFinal(dataToSign.getBytes());
        String signatureB64 = Base64.getUrlEncoder().withoutPadding().encodeToString(signatureBytes);

        // Assemble the final JWT!
        String finalJwt = headerB64 + "." + payloadB64 + "." + signatureB64;
        
        System.out.println("Generated JWT:");
        System.out.println(finalJwt);
        
        System.out.println("\nIf a hacker modifies the Payload Base64 string, the Server will recalculate");
        System.out.println("the signature and it won't match, rejecting the token immediately!");
    }
}
