package Test_java_leanring.test58;

import java.util.LinkedList;
import java.util.List;

/** test58 - LinkedList */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test58: LinkedList ===");
        List<String> list = new LinkedList<>();
        list.add("a"); list.add("b");
        System.out.println(list.get(1));
    }
}
