package TestJava.Test233;

import java.util.LinkedHashMap;
import java.util.Map;

// Implementing an LRU Cache is incredibly simple in Java!
// LinkedHashMap was literally built for this exact purpose.
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int maximumCapacity;

    public LRUCache(int maximumCapacity) {
        // capacity, loadFactor, accessOrder (true = LRU, false = insertion order)
        super(maximumCapacity, 0.75f, true);
        this.maximumCapacity = maximumCapacity;
    }

    // This is the magical trigger! It's called after EVERY insert (put/putAll)
    // If we return true, the eldest (least recently used) entry is deleted!
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maximumCapacity;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 233: LRU Cache (Using LinkedHashMap) ===\n");

        System.out.println("An LRU (Least Recently Used) cache ejects the oldest accessed items");
        System.out.println("when it gets full. This is how Redis and Browser Caches work!\n");

        System.out.println("We are creating a Cache with a Max Capacity of 3.\n");
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A_Data");
        cache.put(2, "B_Data");
        cache.put(3, "C_Data");
        System.out.println("Cache populated: " + cache);

        System.out.println("\nUser queries Key 1. (This makes Key 1 the MOST recently used!)");
        cache.get(1);
        System.out.println("Cache status: " + cache); // Notice 1 moved to the end!

        System.out.println("\nNow we add Key 4 to the full cache...");
        cache.put(4, "D_Data");
        
        System.out.println("\nResult: Did it delete Key 1? No! It deleted Key 2 because Key 2 was the Least Recently Used.");
        System.out.println("Final Cache status: " + cache);
    }
}
