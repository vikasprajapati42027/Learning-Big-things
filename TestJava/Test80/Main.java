package TestJava.Test80;

import java.util.Map;
import java.util.WeakHashMap;

class SessionData {
    String info;
    public SessionData(String info) { this.info = info; }
    @Override
    public String toString() { return info; }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== WeakHashMap & Memory Tutorial ===\n");

        // A WeakHashMap is special. If the KEY object is ONLY referenced by the map
        // (i.e., NO active threads are using that object anymore), the Garbage Collector 
        // is allowed to secretly DELETE the entry from the map to prevent memory leaks!

        Map<SessionData, String> cache = new WeakHashMap<>();

        // Create a strong reference to a session
        SessionData activeSession = new SessionData("User_Vikas_Session_Object");
        
        // Put it in the map
        cache.put(activeSession, "Logged_In_At_10AM");

        // Add another entry, but we DO NOT hold a strong reference to the key variable!
        // We create it inline. The Map is the ONLY thing holding onto it.
        cache.put(new SessionData("User_Guest_Session_Object"), "Logged_In_At_11AM");

        System.out.println("Initial WeakHashMap state:");
        printCache(cache); // Should show both

        System.out.println("\n--- Triggering Garbage Collection ---");
        // Force the JVM to invoke the Garbage Collector now.
        // The Guest session key has NO strong references anywhere in the code.
        System.gc(); 
        
        // Small pause to let GC finish
        Thread.sleep(1000);

        System.out.println("\nState after Garbage Collection:");
        // The Guest entry should be GONE entirely, but Vikas is kept safe 
        // because the 'activeSession' variable still strongly points to it!
        printCache(cache); 
    }

    private static void printCache(Map<?, ?> map) {
        if (map.isEmpty()) {
            System.out.println(" (Cache is completely empty)");
        } else {
            map.forEach((k, v) -> System.out.println(" - Key[" + k + "] = " + v));
        }
    }
}
