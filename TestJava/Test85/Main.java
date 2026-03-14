package TestJava.Test85;

import java.util.Iterator;

// To allow our custom class to be used in a "for-each" loop, 
// we must implement the Iterable interface!
class PageCollection implements Iterable<String> {
    private String[] pages = {"Page 1", "Page 2", "Page 3", "Page 4"};

    // The Iterable interface requires us to provide an Iterator object
    @Override
    public Iterator<String> iterator() {
        return new CustomPageIterator();
    }

    // Creating an inner Iterator class giving us full control over how to step through data
    private class CustomPageIterator implements Iterator<String> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            // Are there more items left?
            return currentIndex < pages.length;
        }

        @Override
        public String next() {
            // Get the current item and move the pointer forward!
            String data = pages[currentIndex];
            currentIndex++;
            return data;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Custom Iterable & Iterator Tutorial ===\n");

        PageCollection book = new PageCollection();

        System.out.println("--- 1. Using modern 'For-Each' loop ---");
        // Because PageCollection implements Iterable, Java magically knows how to loop it!
        for (String page : book) {
            System.out.println("Reading: " + page);
        }

        System.out.println("\n--- 2. Under the hood (The Old Way) ---");
        // This is exactly what the for-each loop transpiles to automatically!
        Iterator<String> manualIterator = book.iterator();
        while (manualIterator.hasNext()) {
            System.out.println("Manual Reading: " + manualIterator.next());
        }
    }
}
