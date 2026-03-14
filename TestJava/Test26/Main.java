package TestJava.Test26;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Array vs ArrayList Tutorial ===");

        // --- 1. Arrays ---
        // Arrays have a FIXED size. You must know how many items it will hold in advance.
        // They are very fast and can hold primitive types (int, double, etc.) directly.
        System.out.println("\n--- 1. Arrays (Fixed Size) ---");
        
        int[] numbersArray = new int[3]; // We create space for exactly 3 integers
        numbersArray[0] = 10;
        numbersArray[1] = 20;
        numbersArray[2] = 30;
        // numbersArray[3] = 40; // This would cause an ArrayIndexOutOfBoundsException!
        
        System.out.println("Array contents: " + Arrays.toString(numbersArray));
        System.out.println("Array length: " + numbersArray.length);

        // --- 2. ArrayList ---
        // ArrayLists are DYNAMIC. They grow and shrink automatically as you add/remove items.
        // They CANNOT hold primitive types directly (must use Wrapper classes like Integer, Double).
        System.out.println("\n--- 2. ArrayList (Dynamic Size) ---");
        
        // We don't need to specify a size!
        ArrayList<Integer> numbersList = new ArrayList<>(); 
        numbersList.add(10);
        numbersList.add(20);
        numbersList.add(30);
        
        // Let's add more! The ArrayList grows automatically.
        numbersList.add(40);
        numbersList.add(50);
        
        // We can also easily remove items
        numbersList.remove(Integer.valueOf(20)); // Remove the number 20
        
        System.out.println("ArrayList contents: " + numbersList);
        System.out.println("ArrayList size: " + numbersList.size());
        
        // --- SUMMARY ---
        // Use Arrays when size is fixed and known (e.g., days of the week).
        // Use ArrayList when you need flexibility to add/remove lots of items.
    }
}
