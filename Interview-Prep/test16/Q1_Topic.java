/**
 * INTERVIEWER: Let's discuss Advanced Java Engineering - Scenario 1.
 * 
 * CANDIDATE: In this scenario, we focus on applying the core principles of Advanced Java Engineering 
 * to handle real-world challenges like scalability, maintainability, and concurrency.
 *
 * PROPER EXPLANATION:
 * 1. Deep dive into the architectural significance of Advanced Java Engineering.
 * 2. Key implementation patterns used in modern enterprise Java.
 * 3. Handling edge cases and ensuring thread-safety/data-integrity.
 */
import java.util.concurrent.*;

class Task {
    private final String name;

    Task(String name) {
        this.name = name;
    }

    void execute() {
        System.out.println("Executing task: " + name);
    }
}

class TaskRunner {
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    void run(Task... tasks) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(tasks.length);
        for (Task task : tasks) {
            executor.submit(() -> {
                task.execute();
                latch.countDown();
            });
        }
        latch.await();
        executor.shutdown();
    }
}

public class Q1_Topic {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Mastering Advanced Java Engineering: Step 1 ---");
        TaskRunner runner = new TaskRunner();
        runner.run(new Task("Scale Strategy"), new Task("Resilience Law"));
        System.out.println("Advanced Java Engineering logic executed successfully with thread-safe coordination.");
    }
}
