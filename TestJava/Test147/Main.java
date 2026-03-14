package TestJava.Test147;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Java Microbenchmark Harness (JMH) Concepts ===\n");

        System.out.println("NEVER benchmark Java code using `System.currentTimeMillis()`!");
        System.out.println("Why? Because the JVM is incredibly smart and does things like:");
        System.out.println("1. Dead Code Elimination (It deletes code that doesn't do anything)");
        System.out.println("2. Loop Unrolling (It optimizes for-loops natively)");
        System.out.println("3. JIT Warmup (Code runs slow at first, then natively fast later)\n");

        System.out.println("--- The JMH Solution ---");
        System.out.println("JMH (org.openjdk.jmh) is the official framework to benchmark Java code accurately.");
        
        System.out.println("\nExample JMH Code Structure (Requires Maven/Gradle to run properly):");
        
        String jmhExample = """
            import org.openjdk.jmh.annotations.*;
            import java.util.concurrent.TimeUnit;
            
            @State(Scope.Thread)
            @BenchmarkMode(Mode.AverageTime)
            @OutputTimeUnit(TimeUnit.NANOSECONDS)
            @Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS) // Warms up the JIT compiler!
            @Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS) // Actually measures
            @Fork(1) // Runs in a clean, separate JVM instance
            public class StringBenchmark {
            
                @Benchmark
                public String testStringConcatenation() {
                    String result = "";
                    for(int i=0; i<100; i++) {
                        result += i; // The bad way
                    }
                    return result; // returning prevents Dead Code Elimination!
                }
                
                @Benchmark
                public String testStringBuilder() {
                    StringBuilder sb = new StringBuilder();
                    for(int i=0; i<100; i++) {
                        sb.append(i); // The good way
                    }
                    return sb.toString();
                }
            }
            """;
            
        System.out.println(jmhExample);
        System.out.println("\nLesson: Always use JMH when proving one algorithm is faster than another in Java!");
    }
}
