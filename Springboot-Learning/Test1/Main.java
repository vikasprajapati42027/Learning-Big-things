package Test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Main class is the entry point of a Spring Boot application.
 * 
 * @SpringBootApplication is a convenience annotation that adds all of the following:
 * 1. @Configuration: Tags the class as a source of bean definitions for the application context.
 * 2. @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, 
 *    other beans, and various property settings.
 * 3. @ComponentScan: Tells Spring to look for other components, configurations, and services in the 
 *    Test1 package, letting it find the controllers.
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        /**
         * SpringApplication.run() perform the following steps:
         * 1. Creates an appropriate ApplicationContext instance (depending on your classpath).
         * 2. Registers a CommandLinePropertySource to expose command-line arguments as Spring properties.
         * 3. Refreshes the application context, loading all singleton beans.
         * 4. Triggers any CommandLineRunner beans.
         */
        SpringApplication.run(Main.class, args);
        
        System.out.println("Spring Boot Application Started Successfully!");
    }
}
