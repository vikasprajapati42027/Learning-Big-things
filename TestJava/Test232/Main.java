package TestJava.Test232;

import java.util.BitSet;

class BloomFilter {
    private final BitSet bitArray;
    private final int numHashes = 3; // We will use 3 simulated hash functions

    public BloomFilter(int size) {
        bitArray = new BitSet(size);
    }

    // Insert an item
    public void add(String item) {
        for (int i = 0; i < numHashes; i++) {
            int hash = getHash(item, i);
            bitArray.set(hash); // Flip the bit to 1
        }
    }

    // Check if an item exists
    public boolean mightContain(String item) {
        for (int i = 0; i < numHashes; i++) {
            int hash = getHash(item, i);
            if (!bitArray.get(hash)) {
                return false; // Definitely NOT in the set!
            }
        }
        return true; // MIGHT be in the set (False Positives are possible)
    }

    // Simulate different hash functions by salting the string with an integer
    private int getHash(String item, int hashIndex) {
        int hash = (item + hashIndex).hashCode();
        return Math.abs(hash % bitArray.size()); // Map to the bit array length
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 232: Bloom Filter (Probabilistic Data Structure) ===\n");

        System.out.println("Problem: A database has 10 Billion usernames. You want to quickly check if");
        System.out.println("         a newly registered username is already taken. A HashSet would use 500GB RAM!\n");

        System.out.println("Solution: Bloom Filter! It uses hashes to flip bits in a tiny array.");
        System.out.println("Catch: It can tell you if an item is 'DEFINITELY NOT' present, or 'PROBABLY' present.");
        System.out.println("       (It has False Positives, but NEVER False Negatives).\n");

        // A small 100-bit Bloom Filter
        BloomFilter filter = new BloomFilter(100);

        System.out.println("Adding users: 'vikas', 'admin', 'superuser'");
        filter.add("vikas");
        filter.add("admin");
        filter.add("superuser");

        System.out.println("\n--- Checks ---");
        System.out.println("Does 'vikas' exist?    " + filter.mightContain("vikas") + " (Probably)");
        System.out.println("Does 'admin' exist?    " + filter.mightContain("admin") + " (Probably)");
        
        System.out.println("Does 'hacker' exist?   " + filter.mightContain("hacker") + " (DEFINITELY NOT)");
        System.out.println("Does 'john_doe' exist? " + filter.mightContain("john_doe") + " (DEFINITELY NOT)");

        System.out.println("\nIf it says 'Probably', THEN you do the expensive Database SQL query to confirm!");
    }
}
