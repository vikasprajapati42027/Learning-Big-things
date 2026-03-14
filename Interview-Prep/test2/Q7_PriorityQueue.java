/**
 * Interviewer: What is a PriorityQueue?
 * Candidate: It's a queue where the "Highest Priority" (usually smallest value) is always at the head.
 */
import java.util.PriorityQueue;
public class Q7_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(50); pq.add(10);
        System.out.println(pq.poll()); // 10
    }
}
