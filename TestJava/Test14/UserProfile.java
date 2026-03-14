package TestJava.Test14;

import java.io.Serializable;

/**
 * To make a Java object serializable (able to be converted to bytes),
 * it MUST implement the java.io.Serializable interface. 
 * This is a "Marker Interface" - it has no methods! It just flags the class.
 */
public class UserProfile implements Serializable {
    
    // It's best practice to declare a serialVersionUID to verify class version during deserialization
    private static final long serialVersionUID = 1L;
    
    private String username;
    
    // The 'transient' keyword means this field will NOT be serialized (ignored during save)
    // Great for passwords, temporary states, or sensitive data.
    private transient String password; 

    public UserProfile(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    
    @Override
    public String toString() {
        return "UserProfile{username='" + username + "', password='" + password + "'}";
    }
}
