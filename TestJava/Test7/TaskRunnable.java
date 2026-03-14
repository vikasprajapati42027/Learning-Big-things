package TestJava.Test7;

/**
 * Way 2 to create a Thread: Implementing the Runnable interface.
 * This is the PREFERRED way because it allows your class to extend another class if needed.
 */
public class TaskRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running a TaskRunnable!");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.out.println("Runnable task interrupted.");
        }
        System.out.println(Thread.currentThread().getName() + " completed its task.");
    }
}
