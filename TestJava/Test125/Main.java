package TestJava.Test125;

import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Base64 Advanced (MIME & URL Encoding) ===\n");

        System.out.println("Earlier we looked at Basic Base64 (Test68). Let's see the advanced encoders Java provides.");

        // 1. URL Safe Base64
        // Standard Base64 uses '+' and '/' characters, which break URLs!
        // URL-Safe Base64 replaces them with '-' and '_'
        System.out.println("\n--- 1. URL-Safe Base64 ---");
        String uriData = "?user=admin&token=secret/key+plus";
        
        String standardEncoded = Base64.getEncoder().encodeToString(uriData.getBytes());
        String urlSafeEncoded = Base64.getUrlEncoder().encodeToString(uriData.getBytes());
        
        System.out.println("Standard: " + standardEncoded); // Might contain harmful URL chars
        System.out.println("URL Safe: " + urlSafeEncoded);  // Safe to put straight into a web URL!

        // 2. MIME Base64
        // Used extensively in Email attachments. It organizes long Base64 strings 
        // into lines of exactly 76 characters, ending with a carriage return/newline.
        System.out.println("\n--- 2. MIME Base64 ---");
        
        // Create an artificially long string
        StringBuilder longData = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            longData.append("This is a very long text stream that simulates an email attachment. ");
        }

        String mimeEncoded = Base64.getMimeEncoder().encodeToString(longData.toString().getBytes());
        System.out.println("\nMIME Encoded Block:\n" + mimeEncoded);
        
        // Decoding back is just as easy
        byte[] decoded = Base64.getMimeDecoder().decode(mimeEncoded);
        System.out.println("\nSuccessfully decoded MIME block back to original " + decoded.length + " bytes.");
    }
}
