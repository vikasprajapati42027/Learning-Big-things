import java.util.*;

// Q4: Immutability — Why and How
public final class Q04_Immutability { // final = can't be subclassed
    
    // All fields are final — assigned once, never changed
    private final String name;
    private final List<String> tags; // Defensive copy needed!

    public Q04_Immutability(String name, List<String> tags) {
        this.name = name;
        // Defensive copy — don't store the caller's list (they might modify it!)
        this.tags = List.copyOf(tags); // Unmodifiable copy
    }

    public String getName() { return name; }
    
    public List<String> getTags() {
        return Collections.unmodifiableList(tags); // Return read-only view
    }

    public static void main(String[] args) {
        List<String> myTags = new ArrayList<>(List.of("Java", "Spring"));
        Q04_Immutability obj = new Q04_Immutability("Demo", myTags);
        
        myTags.add("MODIFIED"); // OK for caller's list
        System.out.println(obj.getTags()); // Still [Java, Spring] — not modified!
    }
}
