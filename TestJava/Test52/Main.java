package TestJava.Test52;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Regular Expressions (Regex) Tutorial ===\n");

        String text = "Contact us at support@example.com or admin@test.org for help.";

        // --- 1. Basic Matching ---
        System.out.println("--- 1. String.matches() ---");
        String simpleZip = "12345";
        // \\d means "digit", {5} means "exactly 5 times"
        boolean isValidZip = simpleZip.matches("\\d{5}"); 
        System.out.println("Is '12345' a valid 5-digit zip code? " + isValidZip);

        // --- 2. Pattern and Matcher (Finding patterns inside a larger text) ---
        System.out.println("\n--- 2. Pattern and Matcher ---");
        
        // Regex for a basic email address
        // [a-zA-Z0-9._-]+  -> 1 or more characters (letters, numbers, dots, dashes, underscores)
        // @                -> literal '@'
        // [a-zA-Z0-9.-]+   -> domain name
        // \\.              -> literal dot
        // [a-zA-Z]{2,6}    -> top level domain (like .com, .org)
        String emailRegex = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";
        
        // Compile the regex into a Pattern
        Pattern emailPattern = Pattern.compile(emailRegex);
        
        // Create a Matcher for our specific text
        Matcher matcher = emailPattern.matcher(text);

        System.out.println("Searching for emails in text: '" + text + "'");
        
        // .find() looks for the next occurrence of the pattern
        while (matcher.find()) {
            // .group() returns the actual text that matched
            System.out.println("Found Email: " + matcher.group());
        }
        
        // --- 3. Splitting and Replacing ---
        System.out.println("\n--- 3. Replace All ---");
        // Hide emails for privacy
        String hiddenText = text.replaceAll(emailRegex, "[HIDDEN]");
        System.out.println(hiddenText);
    }
}
