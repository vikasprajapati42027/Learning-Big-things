/**
 * INTERVIEWER: What are the three uses of the 'final' keyword in Java?
 * 
 * CANDIDATE: 'final' can be applied to variables, methods, and classes.
 * 
 * PROPER EXPLANATION:
 * 1. Final Variable: Makes it a constant. It must be initialized and cannot be changed.
 *    - Blank Final: Initialized in constructor.
 *    - Static Final: Global constant.
 * 2. Final Method: Prevents method overriding by child classes. Essential for security.
 * 3. Final Class: Prevents inheritance. Examples: String, Integer.
 */

// 1. Final Class: Cannot be extended
final class SecurityManager {
    public void validate() {
        System.out.println("Security check passed.");
    }
}

// class HackerManager extends SecurityManager { } // COMPILATION ERROR

class Base {
    // 2. Final Method: Cannot be overridden
    public final void coreLogic() {
        System.out.println("This logic is fixed and cannot be changed by subclasses.");
    }
}

class Child extends Base {
    // public void coreLogic() { } // COMPILATION ERROR
}

public class Q7_Final {
    // 3. Static Final: Global constant
    public static final String CONFIG_URL = "https://api.myapp.com";

    public static void main(String[] args) {
        // 4. Local Final Variable
        final int MAX_ATTEMPTS = 3;
        // MAX_ATTEMPTS = 5; // COMPILATION ERROR
        
        Base obj = new Child();
        obj.coreLogic();
        
        System.out.println("Config: " + CONFIG_URL);
        System.out.println("Max Retries: " + MAX_ATTEMPTS);
    }
}
