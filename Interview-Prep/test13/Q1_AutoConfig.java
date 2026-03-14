/**
 * INTERVIEWER: How does @SpringBootApplication work internally?
 * CANDIDATE: It's a combination of @Configuration, @EnableAutoConfiguration, and @ComponentScan. 
 * The Auto-Configuration uses META-INF/spring.factories (in 2.x) or spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports (in 3.x).
 */
public class Q1_AutoConfig {
    public static void main(String[] args) {
        System.out.println("Spring Boot Startup Principle:");
        System.out.println("1. Scan for @Configuration classes.");
        System.out.println("2. Auto-configure based on JARs present in classpath.");
        System.out.println("3. Conditionals (@ConditionalOnClass, @ConditionalOnBean) decide if a bean is created.");
    }
}
