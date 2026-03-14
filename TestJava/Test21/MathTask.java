package TestJava.Test21;

public class MathTask implements Runnable {
    private final String taskName;

    public MathTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Executing " + taskName + " on: " + Thread.currentThread().getName());
        try {
            // Simulate work (e.g., executing a database query or complex calculation)
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(taskName + " completed.");
    }
}
