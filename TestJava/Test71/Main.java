package TestJava.Test71;

import java.util.HashMap;
import java.util.Map;

// Even with Garbage Collection (GC), Java CAN have memory leaks.
// A memory leak happens when objects are no longer used by the application,
// but the GC cannot remove them because they are still being REFERENCED!

class CustomKey {
    private String name;
    public CustomKey(String name) { this.name = name; }
    
    // BAD!! We forgot to override hashCode() and equals()
    // This is the #1 cause of Memory Leaks involving Maps/Sets!
}

public class Main {
    // A static map (exists for the lifetime of the application)
    private static Map<CustomKey, String> badCache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("=== Memory Leaks Tutorial ===\n");

        System.out.println("--- The HashMap Leak Pattern ---");
        
        System.out.println("Adding 3 items to cache...");
        badCache.put(new CustomKey("Session1"), "Data1");
        badCache.put(new CustomKey("Session2"), "Data2");
        badCache.put(new CustomKey("Session3"), "Data3");

        System.out.println("\nTrying to retrieve 'Session1'...");
        
        // Because we didn't override equals/hashCode, `new CustomKey("Session1")`
        // is considered a BRAND NEW instance, not a match for the old one!
        String data = badCache.get(new CustomKey("Session1"));
        System.out.println("Result: " + data); // Returns null!!
        
        System.out.println("\nSize of badCache: " + badCache.size());
        
        // Let's "update" the old session...
        badCache.put(new CustomKey("Session1"), "NewData");
        
        // Since we can't find the old key, we just added a NEW entry. The old entry is lost forever
        // but it is still sitting inside the Map, taking up memory! It will NEVER BE DELETED!
        System.out.println("Size of badCache after 'update': " + badCache.size() + " (It grew!)");
        
        // Over time, this map grows infinitely until: java.lang.OutOfMemoryError
        System.out.println("\nFix: Always override equals() and hashCode() when using objects as Map keys!");
    }
}
