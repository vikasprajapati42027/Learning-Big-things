package TestJava.Test107;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Pattern Matching (Java 16+) ===\n");

        Object[] items = {
            "Hello Java",
            123,
            null
        };

        System.out.println("Processing generic Objects using Pattern Matching for 'instanceof':\n");

        for (Object item : items) {
            System.out.print(item + " -> ");
            
            // Before Java 16:
            // if (item instanceof String) {
            //     String s = (String) item;
            //     System.out.println(s.length());
            // }

            // Java 16+ Pattern Matching:
            // It automatically casts the object to 's' if true!
            if (item instanceof String s && s.length() > 5) {
                System.out.println("Long String of length " + s.length());
            } else if (item instanceof String s) {
                System.out.println("Short String: " + s);
            } else if (item instanceof Integer i) {
                System.out.println("An Integer value: " + i);
            } else if (item == null) {
                System.out.println("It's literally null.");
            } else {
                System.out.println("Unknown Type");
            }
        }
        
        System.out.println("\nNote: In Java 21+, this becomes even better with Pattern Matching *in Switch* blocks using 'case String s ->' syntax!");
    }
}
