package TestJava.Test226;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 226: Class Data Sharing (CDS) Concept ===\n");

        System.out.println("Problem: When the JVM starts, it loads hundreds of standard Java classes (String, Object, System).");
        System.out.println("It parses their bytecode into internal C++ structures, which takes time and memory.\n");

        System.out.println("Solution: CDS (Class Data Sharing)!");
        System.out.println("1. A 'Shared Archive' (.jsa file) is created containing these pre-parsed classes.");
        System.out.println("2. When a new JVM starts, it simply memory-maps this archive directly!");
        System.out.println("3. This drastically improves startup time (e.g., from 1.5s down to 0.8s) and reduces RAM usage");
        System.out.println("   because multiple JVMs on the same machine can share the same Read-Only memory page.\n");

        System.out.println("Starting in Java 12, a Default CDS Archive is built into the JDK.");
        
        System.out.println("\n--- AppCDS (Application Class Data Sharing) ---");
        System.out.println("You can also dump YOUR OWN classes (like Spring Boot frameworks) into an archive!");
        System.out.println("Command 1: Record the classes your app uses:");
        System.out.println("   java -XX:DumpLoadedClassList=classes.lst -jar myapp.jar");
        
        System.out.println("\nCommand 2: Create the custom archive:");
        System.out.println("   java -Xshare:dump -XX:SharedClassListFile=classes.lst -XX:SharedArchiveFile=app.jsa -jar myapp.jar");
        
        System.out.println("\nCommand 3: Run the app using the new blazing fast archive:");
        System.out.println("   java -XX:SharedArchiveFile=app.jsa -jar myapp.jar");
    }
}
