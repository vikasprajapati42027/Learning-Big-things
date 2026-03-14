package TestJava.Test133;

import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;
import jdk.jfr.Recording;

// Define a Custom JFR Event!
@Name("com.example.HeavyProcessing")
@Label("Heavy Processing Task")
class HeavyProcessingEvent extends Event {
    @Label("Task Name")
    String taskName;
    
    @Label("Items Processed")
    int itemsProcessed;
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Java Flight Recorder (JFR) Basics ===\n");

        System.out.println("JFR is a profiling tool built directly into the JVM with near-zero overhead.");
        System.out.println("It records memory allocation, garbage collection, thread blocking, and custom events!\n");

        // Start a programmatic recording
        try (Recording recording = new Recording()) {
            recording.start();
            System.out.println(">>> JFR Recording Started!");

            System.out.println("Simulating heavy workload...");
            
            // This is where we trigger our custom event!
            // First we instantiate it, then .begin() marks the start time.
            HeavyProcessingEvent event = new HeavyProcessingEvent();
            event.begin();
            
            // Simulate work
            Thread.sleep(1500); 
            
            // Populate data and commit! .commit() marks the end time and writes it to JFR buffers.
            event.taskName = "Data Aggregation";
            event.itemsProcessed = 50000;
            event.commit();
            
            System.out.println("Work complete! Event committed to JFR.");

            recording.stop();
            System.out.println(">>> JFR Recording Stopped.");
            
            // Save the recording to disk so it can be viewed in Java Mission Control (JMC)
            java.nio.file.Path dest = java.nio.file.Paths.get("TestJava/Test133/profile.jfr");
            java.nio.file.Files.createDirectories(dest.getParent());
            recording.dump(dest);
            
            System.out.println("Saved recording to: " + dest.toAbsolutePath());
            System.out.println("Open this file using JDK Mission Control (`jmc`) to analyze performance!");
            
            java.nio.file.Files.delete(dest); // Cleanup for tutorial script
        }
    }
}
