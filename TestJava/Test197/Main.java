package TestJava.Test197;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Custom Annotations (Like javax.annotation)
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)
@interface PostConstruct {}

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)
@interface PreDestroy {}

// A Bean that needs lifecycle management
class DatabaseConnection {
    public DatabaseConnection() {
        System.out.println("1. Constructor called: Object naturally instantiated in memory.");
        // But dependencies (@Autowired) haven't been injected yet! So don't connect to the DB here!
    }

    @PostConstruct
    public void setup() {
        // Safe to use dependencies here, run by the framework right after DI finishes.
        System.out.println("2. @PostConstruct called: Establishing real connection to Database...");
    }

    public void query() {
        System.out.println("3. Bean is active and servicing queries...");
    }

    @PreDestroy
    public void teardown() {
        System.out.println("4. @PreDestroy called: Closing Database connection before JVM exits!");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 197: Application Lifecycle (@PostConstruct / @PreDestroy) ===\n");

        DatabaseConnection bean = new DatabaseConnection();

        // 1. Simulating Framework Initialization Phase
        System.out.println("\n--- Framework Bootstrapping ---");
        invokeLifecycleMethods(bean, PostConstruct.class);

        // 2. Simulating Application Running
        System.out.println("\n--- Application Running ---");
        bean.query();

        // 3. Simulating Framework Shutdown Phase
        System.out.println("\n--- Framework Shutting Down ---");
        invokeLifecycleMethods(bean, PreDestroy.class);
    }

    // A generic helper to run methods marked with specific annotations!
    private static void invokeLifecycleMethods(Object bean, Class<? extends java.lang.annotation.Annotation> annotation) throws Exception {
        Class<?> clazz = bean.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotation)) {
                method.setAccessible(true);
                method.invoke(bean); // Execute the annotated method!
            }
        }
    }
}
