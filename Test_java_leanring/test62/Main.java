package Test_java_leanring.test62;

import java.util.Stack;

/** test62 - Stack */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test62: Stack ===");
        Stack<Integer> s = new Stack<>();
        s.push(1); s.push(2);
        System.out.println(s.pop() + " " + s.pop());
    }
}
