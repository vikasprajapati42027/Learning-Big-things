package TestJava.Test126;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// A simple interface and implementation
interface Database {
    void connect();
    String query(String sql);
}

class RealDatabase implements Database {
    public void connect() { System.out.println("Connecting to physical DB..."); }
    public String query(String sql) { return "Results for: " + sql; }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Dynamic Proxies (Proxy.newProxyInstance) ===\n");

        // Dynamic Proxies allow you to intercept ALL method calls to an interface!
        // This is heavily used in Spring (e.g., @Transactional) and Hibernate!

        Database realDb = new RealDatabase();

        // Let's create an InvocationHandler. This piece of code runs EVERY TIME
        // a method is called on the proxy.
        InvocationHandler loggingHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // Pre-processing
                System.out.println("[PROXY LOG] Intercepted method call: " + method.getName());
                long start = System.nanoTime();

                // Call the actual method on the Real object
                Object result = method.invoke(realDb, args);

                // Post-processing
                long end = System.nanoTime();
                System.out.println("[PROXY LOG] Method execution took: " + (end - start) + " ns");
                
                return result;
            }
        };

        // Create the Proxy object out of thin air! It masquerades as 'Database'
        Database dbProxy = (Database) Proxy.newProxyInstance(
                Database.class.getClassLoader(), 
                new Class[] { Database.class }, 
                loggingHandler);

        System.out.println("--- Using the Proxy ---");
        dbProxy.connect(); // This call will be intercepted!
        
        System.out.println();
        String result = dbProxy.query("SELECT * FROM users");
        System.out.println("Real Result returned to Main: " + result);
    }
}
