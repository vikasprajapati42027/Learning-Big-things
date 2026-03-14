package TestJava.Test132;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ProcessBuilder (Running OS Commands) ===\n");

        // ProcessBuilder is much more powerful and safer than Runtime.getRuntime().exec()!
        // It lets you manage environment variables, working directories, and standard I/O streams.

        System.out.println("--- 1. Executing a Simple Command ('echo') ---");
        try {
            // Build the command
            ProcessBuilder builder = new ProcessBuilder("echo", "Hello from the Linux Subsystem!");
            
            // Start the physical OS process
            Process process = builder.start();

            // Read the output
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("OS Output: " + line);
                }
            }

            // Wait for it to finish and get exit code (0 usually means success)
            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n--- 2. Setting Timeouts and Directory ('ls') ---");
        try {
            ProcessBuilder builder = new ProcessBuilder("ls", "-la");
            builder.directory(new java.io.File("/tmp")); // Change working directory

            Process lsProcess = builder.start();
            
            // We wait a maximum of 2 seconds for the process to finish
            boolean finishedInTime = lsProcess.waitFor(2, TimeUnit.SECONDS);

            if (finishedInTime) {
                System.out.println("Command finished successfully on time!");
            } else {
                System.out.println("Command took too long! Killing it aggressively.");
                lsProcess.destroyForcibly();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
