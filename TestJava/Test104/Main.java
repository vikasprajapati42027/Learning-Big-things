package TestJava.Test104;

import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== WatchService (Directory Monitoring) ===\n");

        // The WatchService hooks directly into the OS's native file event system
        // (like inotify on Linux or FSEvents on macOS) to give you instant notifications
        // when files are created, deleted, or modified!

        Path dirLocation = Paths.get("TestJava/Test104");
        Files.createDirectories(dirLocation);
        System.out.println("Monitoring directory: " + dirLocation.toAbsolutePath());

        // 1. Create a WatchService
        WatchService watcher = FileSystems.getDefault().newWatchService();

        // 2. Register the directory to be watched for specific events
        dirLocation.register(watcher, 
            StandardWatchEventKinds.ENTRY_CREATE, 
            StandardWatchEventKinds.ENTRY_DELETE, 
            StandardWatchEventKinds.ENTRY_MODIFY);

        // Simulation: Create a file in a separate thread so we can trigger the watcher
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                Path tempFile = dirLocation.resolve("new_test_file.txt");
                System.out.println("[Simulation] Creating file...");
                Files.createFile(tempFile);
                
                Thread.sleep(1000);
                System.out.println("[Simulation] Deleting file...");
                Files.delete(tempFile);
            } catch (Exception e) {}
        }).start();


        // 3. The Monitor Loop
        System.out.println("Watcher started. Waiting for events... (Will exit after 2 events for this demo)");
        int eventsCaptured = 0;
        
        while (eventsCaptured < 2) {
            // Block until an event happens in the directory!
            WatchKey key = watcher.take();
            
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                
                // The context is the file name that triggered the event
                Path fileName = (Path) event.context();
                System.out.println(">>> Event: " + kind.name() + " -> File: " + fileName);
                eventsCaptured++;
            }
            
            // Reset the key. If it's invalid (directory deleted), stop watching.
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
        
        watcher.close();
        System.out.println("Stopping WatchService.");
    }
}
