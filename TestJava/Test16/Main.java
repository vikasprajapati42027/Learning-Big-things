package TestJava.Test16;

import java.lang.reflect.Method;

public class Main {
    
    // Applying our custom annotation!
    @ImportantTask(priority = 10, description = "Startup system diagnostics")
    public void runDiagnostics() {
        System.out.println("Running diagnostics...");
    }

    // This method does not have the annotation
    public void standardCleanup() {
        System.out.println("Running standard cleanup...");
    }

    // Applying it with default values
    @ImportantTask
    public void defaultTask() {
        System.out.println("Running default task...");
    }

    public static void main(String[] args) {
        System.out.println("=== Custom Annotations & Reflection Tutorial ===");
        
        Main obj = new Main();
        Class<?> clazz = obj.getClass();
        
        System.out.println("\n--- Processing Annotations ---");
        // We use Reflection (from Test15) to find methods that have our Annotation
        for (Method method : clazz.getDeclaredMethods()) {
            
            // Check if this method has the @ImportantTask annotation
            if (method.isAnnotationPresent(ImportantTask.class)) {
                
                // Get the annotation object itself to read its properties
                ImportantTask annotation = method.getAnnotation(ImportantTask.class);
                
                System.out.println("Found Annotated Method: " + method.getName());
                System.out.println(" - Priority: " + annotation.priority());
                System.out.println(" - Description: " + annotation.description());
                System.out.println("---------------------------------");
            }
        }
    }
}
