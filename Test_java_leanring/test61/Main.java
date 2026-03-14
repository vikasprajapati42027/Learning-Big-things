package Test_java_leanring.test61;

import java.util.Queue;
import java.util.LinkedList;

/** test61 - Queue */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test61: Queue ===");
        Queue<String> q = new LinkedList<>();
        q.offer("first"); q.offer("second");
        System.out.println(q.poll() + " " + q.poll());
    }
}
