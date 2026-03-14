package TestJava.Test219;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 219: TLS/SSL Handshake Concept ===\n");

        System.out.println("Connecting to HTTPS requires a complex dance before any HTTP data is sent.");
        System.out.println("This happens under the hood of Java's `HttpsURLConnection`.\n");

        System.out.println("--- The TLS 1.2 Handshake ---");
        
        System.out.println("1. ClientHello: Client sends supported cipher suites and a random number (ClientRandom).");
        
        System.out.println("2. ServerHello: Server picks a cipher suite (e.g., TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384),");
        System.out.println("   sends its own random number (ServerRandom), and sends its X.509 Certificate.");
        
        System.out.println("3. Client Verification: Client verifies the server's Certificate against its TrustStore.");
        
        System.out.println("4. PreMasterSecret: Client generates a PreMasterSecret, encrypts it with the Server's PUBLIC Key,");
        System.out.println("   and sends it to the Server.");
        
        System.out.println("5. Server uses its PRIVATE Key to decrypt the PreMasterSecret.");
        
        System.out.println("6. MasterSecret: BOTH sides independently combine ClientRandom + ServerRandom + PreMasterSecret");
        System.out.println("   to generate the exact same MasterSecret (Symmetric Key)!");
        
        System.out.println("7. 'Finished' messages: Both sides encrypt a handshake summary with the new Symmetric Key.");
        System.out.println("   If successful, the secure tunnel is up! HTTP data begins flowing!\n");

        System.out.println("Note: TLS 1.3 optimizes this to take only 1 Round Trip instead of 2!");
    }
}
