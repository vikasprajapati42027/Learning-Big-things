package Test_java_leanring.test59;

import java.util.TreeSet;
import java.util.Set;

/** test59 - TreeSet (sorted) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test59: TreeSet ===");
        Set<String> set = new TreeSet<>();
        set.add("c"); set.add("a"); set.add("b");
        System.out.println(set);
    }
}
