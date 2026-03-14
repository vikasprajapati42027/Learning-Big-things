package Test_java_leanring.test129;

import java.util.Deque;
import java.util.ArrayDeque;

/** test129 - Deque */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test129: Deque ===");
        Deque<String> d = new ArrayDeque<>();
        d.addFirst("a");
        d.addLast("b");
        System.out.println(d.pollFirst() + " " + d.pollFirst());
    }
}
