package TestJava.Test84;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Immutable Collections vs Unmodifiable Views ===\n");

        List<String> originalSource = new ArrayList<>(List.of("A", "B", "C"));

        System.out.println("--- 1. Unmodifiable View (Collections.unmodifiableList) ---");
        // Creates a READ-ONLY VIEW over the original list.
        List<String> view = Collections.unmodifiableList(originalSource);
        
        System.out.println("View: " + view);
        try {
            view.add("D"); // Fails: View is read-only!
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot add directly to View!");
        }
        
        // DANGER: If the original source changes, the VIEW changes too!
        originalSource.add("Z");
        System.out.println("View after source was modified: " + view); // View now shows Z!
        System.out.println("Conclusion: Unmodifiable views are NOT truly immutable.\n");

        // RESET
        originalSource = new ArrayList<>(List.of("A", "B", "C"));

        System.out.println("--- 2. Truly Immutable Collections (List.copyOf) ---");
        // Creates a completely separate, immutable COPY in Java 10+
        List<String> trueImmutable = List.copyOf(originalSource);
        
        System.out.println("Immutable: " + trueImmutable);
        
        // Modify the original source
        originalSource.add("Z");
        
        System.out.println("Immutable after source was modified: " + trueImmutable); // Remains ABC!
        System.out.println("Conclusion: List.copyOf() creates a truly independent, immutable lockbox.");
    }
}
