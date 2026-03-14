package TestJava.Test220;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 220: CORS vs CSRF Concepts (Web Security) ===\n");

        System.out.println("In Web Frameworks like Spring Security, people always confuse these two:\n");

        System.out.println("--- 1. CORS (Cross-Origin Resource Sharing) ---");
        System.out.println("Problem: You own 'api.example.com'. Browsers block Javascript on 'app.com'");
        System.out.println("         from reading your data because they are different origins.");
        System.out.println("Who it protects: Mostly the USER (stops malicious websites reading their private data).");
        System.out.println("Solution: The Server sends 'Access-Control-Allow-Origin: https://app.com'.\n");

        System.out.println("--- 2. CSRF (Cross-Site Request Forgery) ---");
        System.out.println("Problem: You are logged into Bank.com. In another tab, Evil.com contains a hidden form");
        System.out.println("         that POSTs to Bank.com/transfer. Because you are logged in, the browser");
        System.out.println("         automatically includes your session cookies. The bank processes it!");
        System.out.println("Who it protects: The SERVER (stops unauthorized state-changing actions).");
        System.out.println("Solution: The Server gives the frontend a random 'CSRF Token'.");
        System.out.println("          Any POST request must include this token in the body/header.");
        System.out.println("          Evil.com cannot read the token due to Same-Origin Policy, so its POST fails!\n");
        
        System.out.println("Summary:");
        System.out.println("CORS blocks unauthorized reading. CSRF blocks unauthorized writing.");
    }
}
