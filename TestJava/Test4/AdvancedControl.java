package TestJava.Test4;

/**
 * Interface 2: Advanced Control
 * 
 * INTERFACE INHERITANCE: One interface 'extends' another.
 * This means anyone who implements AdvancedControl MUST also 
 * provide logic for methods in BasicControl!
 */
public interface AdvancedControl extends BasicControl {
    void setting(String mode);
}
