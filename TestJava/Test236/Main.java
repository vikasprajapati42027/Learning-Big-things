package TestJava.Test236;

import java.util.Arrays;

// A highly simplified version of Android's SparseArray
class SparseArray<E> {
    private int[] keys;
    private Object[] values;
    private int size;

    public SparseArray(int initialCapacity) {
        keys = new int[initialCapacity];
        values = new Object[initialCapacity];
        size = 0;
    }

    public void put(int key, E value) {
        // Binary search to find where to put the key
        int index = Arrays.binarySearch(keys, 0, size, key);
        
        if (index >= 0) {
            // Key already exists, just update value
            values[index] = value;
        } else {
            // Key doesn't exist, ~index is the insertion point!
            int insertIndex = ~index;
            
            // For simplicity, assuming array is big enough (real ones resize)
            if (size >= keys.length) throw new RuntimeException("Array Full!");
            
            // Shift elements right to make room
            System.arraycopy(keys, insertIndex, keys, insertIndex + 1, size - insertIndex);
            System.arraycopy(values, insertIndex, values, insertIndex + 1, size - insertIndex);
            
            keys[insertIndex] = key;
            values[insertIndex] = value;
            size++;
        }
    }

    @SuppressWarnings("unchecked")
    public E get(int key) {
        int index = Arrays.binarySearch(keys, 0, size, key);
        if (index >= 0) {
            return (E) values[index];
        } else {
            return null; // Not found
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 236: SparseArray Concept ===\n");

        System.out.println("Problem: HashMap<Integer, String> uses Integer objects. Every Integer takes 16 bytes!");
        System.out.println("         If you have 100,000 items, Autoboxing eats up megabytes of RAM.\n");

        System.out.println("Solution: SparseArray. It uses a primitive int[] for keys and Object[] for values.");
        System.out.println("          It keeps the int[] sorted and uses Binary Search for O(log N) lookups.");
        System.out.println("          It's slower than HashMap O(1), but uses WAY less memory. Default in Android.\n");

        SparseArray<String> sparseArray = new SparseArray<>(10);
        
        System.out.println("Inserting keys: 10, 5, 20 (Notice they go in randomly)");
        sparseArray.put(10, "Ten");
        sparseArray.put(5, "Five");
        sparseArray.put(20, "Twenty");
        
        System.out.println("\nRetrieving...");
        System.out.println("Key 5: " + sparseArray.get(5));
        System.out.println("Key 20: " + sparseArray.get(20));
        System.out.println("Key 99 (Not present): " + sparseArray.get(99));
    }
}
