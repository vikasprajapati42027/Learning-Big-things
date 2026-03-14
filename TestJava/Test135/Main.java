package TestJava.Test135;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== JavaCompiler API ===\n");

        System.out.println("The JavaCompiler API allows you to compile Java source code Programmatically AT RUNTIME!");

        // 1. Create a dynamic source file!
        Path tempSource = Path.of("TestJava/Test135/DynamicGreeting.java");
        
        String sourceCode = """
            package TestJava.Test135;
            public class DynamicGreeting {
                public void sayHello() {
                    System.out.println(">>> Hello from dynamically compiled & executed code!");
                }
            }
            """;
        
        Files.writeString(tempSource, sourceCode);
        System.out.println("Created source file: " + tempSource);

        // 2. Get the System Java Compiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        
        if (compiler == null) {
            System.err.println("Compiler API is not available! (Are you running a JRE instead of a JDK?)");
            return;
        }

        // 3. Compile the file!
        System.out.println("Compiling...");
        // This is equivalent to running `javac DynamicGreeting.java`
        int compilationResult = compiler.run(null, null, null, tempSource.toString());

        if (compilationResult == 0) {
            System.out.println("Compilation successful!");

            // 4. Load the dynamically compiled class into memory
            // We use the system class loader since we just compiled the file into our source directory.
            Class<?> dynamicClass = Class.forName("TestJava.Test135.DynamicGreeting");

            // 5. Instantiate and execute the method via Reflection
            System.out.println("\nExecuting Dynamic Code:");
            Object instance = dynamicClass.getDeclaredConstructor().newInstance();
            dynamicClass.getMethod("sayHello").invoke(instance);

            // Cleanup the dynamically created .class file
            Files.deleteIfExists(Path.of("TestJava/Test135/DynamicGreeting.class"));

        } else {
            System.out.println("Compilation Failed!");
        }

        // Cleanup the source file
        Files.deleteIfExists(tempSource);
    }
}
