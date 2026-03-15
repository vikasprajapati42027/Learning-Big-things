/**
 * INTERVIEWER: How does @SpringBootApplication work internally?
 * CANDIDATE: It's a combination of @Configuration, @EnableAutoConfiguration, and @ComponentScan. 
 * The Auto-Configuration uses META-INF/spring.factories (in 2.x) or spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports (in 3.x).
 */
import java.util.*;

public class Q1_AutoConfig {
    static class Condition {
        private final String description;

        Condition(String description) {
            this.description = description;
        }

        boolean matches(Set<String> classpath) {
            boolean match = classpath.contains(description);
            System.out.println("Checking condition '" + description + "': " + (match ? "matched" : "not matched"));
            return match;
        }
    }

    static class AutoConfigurationRegistry {
        private final List<Condition> conditions = new ArrayList<>();

        void register(Condition condition) {
            conditions.add(condition);
        }

        void evaluate(Set<String> classpath) {
            System.out.println("Auto-configuration decisions:");
            conditions.forEach(condition -> {
                if (condition.matches(classpath)) {
                    System.out.println("  -> Registering bean for " + condition.description);
                }
            });
        }
    }

    public static void main(String[] args) {
        System.out.println("Spring Boot Startup Principle:");
        AutoConfigurationRegistry registry = new AutoConfigurationRegistry();
        registry.register(new Condition("spring-web"));
        registry.register(new Condition("spring-orm"));
        registry.evaluate(new HashSet<>(Arrays.asList("spring-web", "spring-core")));
    }
}
