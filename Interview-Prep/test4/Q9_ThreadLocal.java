/**
 * Interviewer: What is ThreadLocal?
 * Candidate: It provides a variable that is LOCAL to a thread. Each thread has its own isolated copy.
 */
public class Q9_ThreadLocal {
    ThreadLocal<Integer> id = new ThreadLocal<>();
}
