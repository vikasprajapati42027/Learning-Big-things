package TestJava.Test15;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Java Reflection API Tutorial ===");
        
        SecretClass secretObject = new SecretClass();

        try {
            // 1. Inspecting the Class Definition
            Class<?> clazz = secretObject.getClass();
            System.out.println("\n--- 1. Inspecting the Class ---");
            System.out.println("Class Name: " + clazz.getName());
            
            // 2. Reading a PRIVATE Field
            System.out.println("\n--- 2. Accessing Private Fields ---");
            Field secretField = clazz.getDeclaredField("topSecretCode");
            
            // This is the MAGIC! We disable the Java access checks (making the private field accessible)
            secretField.setAccessible(true);
            
            String code = (String) secretField.get(secretObject); // Reading the value!
            System.out.println("Intercepted Private Code: " + code);
            
            // 3. Modifying a PRIVATE Field
            secretField.set(secretObject, "HACKED_000");
            System.out.println("New Intercepted Code: " + secretField.get(secretObject));

            // 4. Invoking a PRIVATE Method
            System.out.println("\n--- 3. Invoking Private Methods ---");
            Method secretMethod = clazz.getDeclaredMethod("launchMissiles");
            
            // Disable access checks for the method too!
            secretMethod.setAccessible(true);
            
            // Invoke (call) the method on our secretObject
            secretMethod.invoke(secretObject);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        /* 
         * IMPORTANT: 
         * Reflection is incredibly powerful (frameworks like Spring and Hibernate 
         * use it extensively to wire up dependencies and create proxies).
         * However, it is SLOW and breaks Encapsulation. Use it only when necessary!
         */
    }
}
