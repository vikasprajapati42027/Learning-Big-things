/**
 * INTERVIEWER: Why is it better to implement Runnable than extend Thread?
 * 
 * CANDIDATE: Implementing Runnable is decoupled and flexible. Extending Thread 
 * limits inheritance since Java doesn't support multiple inheritance of classes.
 * 
 * PROPER EXPLANATION:
 * 1. Decoupling: Runnable separates the task from the Thread execution logic.
 * 2. Inheritance: If you extend Thread, you can't extend any other class (like BaseService).
 * 3. Composition: You can pass one Runnable to different types of Thread Pools/Executors.
 */

class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing Task in: " + Thread.currentThread().getName());
    }
}

public class Q1_Thread_vs_Runnable {
    public static void main(String[] args) {
        // Implementing Runnable
        MyTask task = new MyTask();
        Thread thread1 = new Thread(task);
        thread1.setName("Task-Thread");
        thread1.start();

        // Using Lambda (Modern way)
        new Thread(() -> System.out.println("Lambda Thread running")).start();
    }
}
