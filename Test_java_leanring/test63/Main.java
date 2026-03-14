package Test_java_leanring.test63;

import java.util.PriorityQueue;
import java.util.Queue;

/** test63 - PriorityQueue */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test63: PriorityQueue ===");
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(30); pq.offer(10); pq.offer(20);
        System.out.println(pq.poll() + " " + pq.poll());
    }
}
