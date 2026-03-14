package Test_java_leanring.test27;

import java.util.HashSet;
import java.util.Set;

/** test27 - HashSet (no duplicates) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test27: HashSet ===");
        Set<String> set = new HashSet<>();
        set.add("A"); set.add("B"); set.add("A");
        System.out.println(set.size() + " " + set);
    }
}
