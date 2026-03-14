package TestJava.Test180;

import java.util.ArrayList;
import java.util.List;

// 1. Abstract class / Interface
abstract class Logger {
    public abstract void log(String message);
}

// 2. Concrete Implementation (Real Object)
class ConsoleLogger extends Logger {
    @Override
    public void log(String message) {
        System.out.println("[INFO] " + message);
    }
}

// 3. The Null Object (The hero of this pattern!)
// It implements the exact same interface, but DOES ABSOLUTELY NOTHING.
class NullLogger extends Logger {
    @Override
    public void log(String message) {
        // Do nothing!
    }
}

// 4. Client Code
class Application {
    private Logger logger;

    // By defaulting to NullLogger, we NEVER have to check `if(logger != null)`!
    public Application(Logger logger) {
        this.logger = (logger == null) ? new NullLogger() : logger;
    }

    public void processData() {
        // Safe to call without NullPointerExceptions!
        logger.log("Processing started...");
        logger.log("Data crunched.");
        logger.log("Processing finished.");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 180: Null Object Pattern ===\n");

        System.out.println("Instead of returning a dangerous 'null' reference which causes NullPointerExceptions,");
        System.out.println("return a 'Null Object' that implements the interface but does nothing.\n");

        System.out.println("--- Scenario 1: App WITH Logging enabled ---");
        Application verboseApp = new Application(new ConsoleLogger());
        verboseApp.processData();

        System.out.println("\n--- Scenario 2: App WITHOUT Logging (Pass Null!) ---");
        // No NullPointerException! It gracefully just consumes the logs into the void.
        Application silentApp = new Application(null);
        silentApp.processData();
        System.out.println("(Processing happened silently.)");
    }
}
