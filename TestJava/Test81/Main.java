package TestJava.Test81;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== IdentityHashMap Tutorial ===\n");

        // IdentityHashMap is a Map that compares keys using Reference Equality (==)
        // instead of Logical Equality (.equals()).
        // This means two keys are considered equal ONLY if they are the exact same object in memory!

        System.out.println("--- 1. Normal HashMap vs IdentityHashMap ---");
        
        // Two separate string objects with the SAME content.
        String key1 = new String("SecretCode");
        String key2 = new String("SecretCode");

        // Normal HashMap uses .equals()
        Map<String, String> normalMap = new HashMap<>();
        normalMap.put(key1, "Value 1");
        normalMap.put(key2, "Value 2"); 
        
        System.out.println("Normal HashMap size : " + normalMap.size()); // Size is 1, key2 overwrote key1!
        
        // IdentityHashMap uses ==
        Map<String, String> identityMap = new IdentityHashMap<>();
        identityMap.put(key1, "Value 1");
        identityMap.put(key2, "Value 2");
        
        System.out.println("IdentityHashMap size: " + identityMap.size()); // Size is 2! They are different objects!

        System.out.println("\n--- 2. Retrieving Values ---");
        System.out.println("Getting value with key1 : " + identityMap.get(key1));
        System.out.println("Getting value with key2 : " + identityMap.get(key2));
        System.out.println("Getting with NEW string : " + identityMap.get(new String("SecretCode"))); // returns null!
        
        // IdentityHashMap is rarely used in typical business logic. 
        // It's mainly used for serialization frameworks, strict caching, and JVM internals.
    }
}
