package TestJava.Test112;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sequenced Collections (Java 21+) ===\n");

        System.out.println("Java 21 introduced 'SequencedCollection', standardizing how we get the first/last elements.");
        
        List<String> list = new ArrayList<>(List.of("First", "Middle", "Last"));

        System.out.println("\n--- Java 17 Approach ---");
        System.out.println("List: " + list);
        System.out.println("Get First: " + list.get(0));
        System.out.println("Get Last : " + list.get(list.size() - 1));
        
        System.out.println("\n--- Java 21+ Approach (SequencedCollection API) ---");
        System.out.println("In Java 21, all ordered collections (List, Deque, LinkedHashSet, etc.) have new methods:");
        System.out.println("- list.getFirst()");
        System.out.println("- list.getLast()");
        System.out.println("- list.addFirst() / addLast()");
        System.out.println("- list.removeFirst() / removeLast()");
        System.out.println("- list.reversed()");
        
        System.out.println("\nThis eliminates the awkward 'list.get(list.size() - 1)' boilerplate!");
    }
}
