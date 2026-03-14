# Test 1: Understanding @SpringBootApplication

This module explains the core entry point of any Spring Boot application.

## The `@SpringBootApplication` Annotation

This single annotation is equivalent to using `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan` with their default attributes.

### 1. `@SpringBootConfiguration`
- Indicates that the class provides Spring Boot application configuration.
- It is a specialized form of the `@Configuration` annotation.

### 2. `@EnableAutoConfiguration`
- This is the "magic" of Spring Boot. 
- It attempts to automatically configure your Spring application based on the dependencies you have added.
- For example, if `spring-boot-starter-web` is on the classpath, it sets up an embedded Tomcat and Spring MVC.

### 3. `@ComponentScan`
- Tells Spring where to look for components (`@Component`, `@Service`, `@Repository`, `@Controller`).
- By default, it scans the package of the class that declares it and all its sub-packages.

## The `main` Method

The `main` method uses `SpringApplication.run(Main.class, args)` to bootstrap the application.

```java
public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
}
```

- **`Main.class`**: Tells Spring Boot which class is the primary configuration source.
- **`args`**: Passes command-line arguments to the Spring application.

## Learning Takeaway
Every Spring Boot app starts with a main class annotated with `@SpringBootApplication` which triggers the component scanning and auto-configuration that makes Spring Boot so powerful.
