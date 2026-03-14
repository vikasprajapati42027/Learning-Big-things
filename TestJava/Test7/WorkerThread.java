package TestJava.Test7;

/**
 * Way 1 to create a Thread: Extending the Thread class.
 * This is simpler but limits you because Java doesn't support multiple inheritance.
 * If you extend Thread, you can't extend any other class!
 */
public class WorkerThread extends Thread {
    
    public WorkerThread(String name) {
        super(name); // Set the thread's name
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is starting...");
        try {
            // Simulate some work being doing by putting the thread to sleep for 500ms
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
        System.out.println(Thread.currentThread().getName() + " has finished!");
    }
}
