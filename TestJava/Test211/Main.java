package TestJava.Test211;

import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 211: KeyStore & TrustStore Concept ===\n");

        System.out.println("KeyStore: Holds YOUR Private Keys and Certificates (Proving who you are).");
        System.out.println("TrustStore: Holds Public Certificates of OTHERS you trust (like Verisign, Let's Encrypt).\n");

        // 1. Create a KeyStore in Memory (PKCS12 is the modern standard over JKS)
        KeyStore ks = KeyStore.getInstance("PKCS12");
        
        // Initialize an empty keystore
        char[] password = "changeit".toCharArray();
        ks.load(null, password);

        System.out.println("Empty PKCS12 KeyStore created in memory.");

        // In a real scenario, you would read this from disk:
        // ks.load(new FileInputStream("mykeystore.p12"), password);
        // Certificate cert = ks.getCertificate("my-server-alias");
        
        System.out.println("Usually configured in Spring Boot via:");
        System.out.println("server.ssl.key-store=classpath:keystore.p12");
        System.out.println("server.ssl.key-store-password=changeit\n");

        // Let's print out the default Java TrustStore location
        String trustStorePath = System.getProperty("javax.net.ssl.trustStore");
        if (trustStorePath == null) {
            trustStorePath = System.getProperty("java.home") + "/lib/security/cacerts";
        }
        System.out.println("Java's default TrustStore (cacerts) is located at:\n" + trustStorePath);
        System.out.println("(This file contains all the Root CAs your Java app trusts by default!)");
    }
}
