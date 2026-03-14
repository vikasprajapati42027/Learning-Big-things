package TestJava.Test227;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 227: GraalVM Ahead-of-Time (AOT) Compilation Concept ===\n");

        System.out.println("Traditional Java (JIT - Just In Time):");
        System.out.println("   Java Code -> Bytecode (.class) -> JVM -> Interpreter -> JIT Compiler (Wait for warmup) -> Native Machine Code");
        System.out.println("   * Result: Slow startup time (seconds), high memory footprint, eventually very fast.\n");

        System.out.println("GraalVM Native Image (AOT - Ahead Of Time):");
        System.out.println("   Java Code -> Bytecode -> GraalVM Compiler -> Linux/Mac/Win Executable (.exe / ELF)");
        System.out.println("   * Result: Instant startup (milliseconds!), very low RAM usage (no JVM overhead!).");
        System.out.println("   * Tradeoff: Slower peak throughput than JIT, completely static (no new classes at runtime).\n");

        System.out.println("--- How it works ---");
        System.out.println("When compiling, GraalVM does a 'Closed World Analysis'. It traces every possible path");
        System.out.println("from public static void main(). Any class/method not reachable is simply DELETED.");
        System.out.println("This creates a tiny, self-contained binary.\n");

        System.out.println("The Catch: Reflection (Dynamic logic) breaks this analysis! If you use Reflection (like Spring/Hibernate do),");
        System.out.println("GraalVM won't know about those classes at compile time, and your app will crash.");
        System.out.println("You have to manually provide 'reflect-config.json' to whitelist classes for reflection.\n");

        System.out.println("Spring Native solves this by pre-analyzing all @Autowired and @Components at compile time,");
        System.out.println("replacing reflection with hardcoded standard Java before handing it to GraalVM!");
    }
}
