package TestJava.Test54;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Timer and TimerTask Tutorial ===\n");

        // Timer allows scheduling a task to run once at a future time, or to repeat at intervals.
        // Note: For modern, complex scheduling, java.util.concurrent.ScheduledExecutorService is preferred.
        Timer timer = new Timer();

        System.out.println("Application started. Scheduling a task...");

        // A TimerTask is the actual job that will run
        TimerTask reminderTask = new TimerTask() {
            int counter = 0;
            
            @Override
            public void run() {
                counter++;
                System.out.println(">>> [Timer Alert] Checking system health... (Attempt " + counter + ")");
                
                // Stop the timer after 3 executions
                if (counter >= 3) {
                    System.out.println("Task complete. Cancelling timer.");
                    timer.cancel(); // Stops all scheduled tasks on this timer
                }
            }
        };

        // scheduleAtFixedRate(task, delay_before_start, period_between_runs)
        // Start after 1000ms (1 sec), then repeat every 500ms (0.5 sec)
        timer.scheduleAtFixedRate(reminderTask, 1000, 500);

        System.out.println("Main thread is free! Waiting for timer tasks to finish...");
    }
}
