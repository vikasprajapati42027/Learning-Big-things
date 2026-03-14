import java.util.HashMap;

// Q2: How does HashMap work internally?
public class Q02_HashMap_Internals {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Step 1: hash("Vikas") → bucket index = hash % 16 (default capacity)
        // Step 2: If bucket is empty → store entry there
        // Step 3: If bucket has entries (COLLISION) → store as LinkedList (or tree if > 8)
        map.put("Vikas", 1);
        map.put("Rahul", 2);

        // Get: hash("Vikas") → same bucket → compare keys → return value
        System.out.println(map.get("Vikas")); // 1

        // Demonstrate key concept: equals() and hashCode() must be consistent
        System.out.println("Vikas".hashCode()); // Always same for same string
    }
}

// Important Rule: If you override equals(), you MUST override hashCode()
// Otherwise HashMap breaks completely!

class Person {
    String name;
    Person(String n) { this.name = n; }

    @Override public boolean equals(Object o) {
        if (!(o instanceof Person p)) return false;
        return this.name.equals(p.name);
    }

    @Override public int hashCode() {
        return this.name.hashCode(); // Must match equals!
    }
}
