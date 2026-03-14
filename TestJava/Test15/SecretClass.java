package TestJava.Test15;

/**
 * A standard class with private fields and private methods.
 * Normally, outside classes CANNOT access these.
 * But Reflection says: "Hold my coffee!"
 */
public class SecretClass {
    // These are strictly PRIVATE! 
    private String topSecretCode = "AGENT_007";
    
    public SecretClass() {
        System.out.println("SecretClass instance created.");
    }
    
    // A private method that can't be called directly
    private void launchMissiles() {
        System.out.println(">>> WARNING: MISSILES LAUNCHED! <<<");
    }
    
    // A public method just to prove we can call it normally
    public void publicGreeting() {
        System.out.println("Hello from the public side.");
    }
}
