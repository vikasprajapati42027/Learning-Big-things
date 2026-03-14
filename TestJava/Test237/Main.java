package TestJava.Test237;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 237: SkipList (ConcurrentSkipListMap) ===\n");

        System.out.println("SkipList is a 'Fast Linked List' with express lanes! It provides O(log N)");
        System.out.println("search, insert, and delete, just like a Red-Black Tree (TreeMap).\n");

        System.out.println("Why use it over TreeMap? Because SkipLists are much easier to make CONCURRENT.");
        System.out.println("Java's ConcurrentSkipListMap is the thread-safe alternative to TreeMap!\n");

        // Thread-safe AND sorted!
        ConcurrentNavigableMap<Integer, String> skipList = new ConcurrentSkipListMap<>();

        skipList.put(50, "Fifty");
        skipList.put(10, "Ten");
        skipList.put(30, "Thirty");
        skipList.put(20, "Twenty");
        skipList.put(40, "Forty");

        System.out.println("SkipList Contents (Automatically Sorted!):");
        System.out.println(skipList);

        System.out.println("\nSince it's navigable, we can do fast range queries:");
        System.out.println("Give me everything >= 30:");
        System.out.println(skipList.tailMap(30)); 
        
        System.out.println("\nGive me the closest key <= 25:");
        System.out.println(skipList.floorEntry(25));
        
        System.out.println("\nAnd unlike TreeMap, multiple threads can safely read/write to this simultaneously");
        System.out.println("without blocking the whole data structure!");
    }
}
