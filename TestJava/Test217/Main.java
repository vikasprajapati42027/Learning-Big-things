package TestJava.Test217;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 217: X.509 Certificates Parsing ===\n");

        System.out.println("An X.509 Certificate is just a Public Key attached to an Identity,");
        System.out.println("which is digitally signed by a trusted Certificate Authority (CA)!\n");

        // A fake, self-signed PEM formatted certificate (Truncated for brevity)
        String pemCert = 
            "-----BEGIN CERTIFICATE-----\n" +
            "MIICVjCCAb6gAwIBAgIGAXv4vMz3MA0GCSqGSIb3DQEBCwUAMBIxEDAOBgNVBAMM\n" +
            "B1Rlc3QgQ0EwHhcNMjEwOTAxMDAwMDAwWhcNMzEwOTAxMDAwMDAwWjASMRAwDgYD\n" +
            "VQQDDAdUZXN0IENBMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC6w22tX8tM\n" +
            "I6W8rJd9yv/R0ZJ0t7Z1qfC9/o5n1V/o7w5k/9fFq/kS5x87/0rA1eZ5O02pE3Kj\n" +
            "u2FmI6s4qN0E5Y6Y7Z3y0y69+1Y/eL0S+QIDAQABo1AwTjAdBgNVHQ4EFgQU/8D5\n" +
            "+Y0Y4S80z1f7x+O/6Q4H2KgwHwYDVR0jBBgwFoAU/8D5+Y0Y4S80z1f7x+O/6Q4H\n" +
            "2KgwDAYDVR0TBAUwAwEB/zANBgkqhkiG9w0BAQsFAAOBgQA9y6E0r6d8xYt/q9Y/\n" +
            "W7Y/T5a4O6Q3U4Z2Z/E/Z7K0W9z8x/U9Y5uX3sY9y/U7Z6Z4X6w8E/y5F/w8H3V6\n" +
            "3+t/I2/F8L7O0/H6f2F7f1b7Q==\n" +
            "-----END CERTIFICATE-----";

        try {
            InputStream is = new ByteArrayInputStream(pemCert.getBytes());
            CertificateFactory factory = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) factory.generateCertificate(is);

            System.out.println("Certificate Loaded Successfully!");
            System.out.println("Subject (Who owns it): " + cert.getSubjectX500Principal().getName());
            System.out.println("Issuer (Who signed it): " + cert.getIssuerX500Principal().getName());
            System.out.println("Valid From: " + cert.getNotBefore());
            System.out.println("Valid Until: " + cert.getNotAfter());
            System.out.println("Signature Algorithm: " + cert.getSigAlgName());
            
            System.out.println("\nExtracted Public Key Type: " + cert.getPublicKey().getAlgorithm());
            
        } catch (Exception e) {
            System.out.println("Certificate parsing failed (Expected since the mock PEM is invalid/truncated).");
            System.out.println("But CertificateFactory is the right class to use for .crt or .pem files!");
        }
    }
}
