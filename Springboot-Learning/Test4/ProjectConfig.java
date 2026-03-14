package Test4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration tells Spring that this class contains Bean definitions.
 * It's used for manual configuration.
 */
@Configuration
public class ProjectConfig {

    /**
     * @Bean tells Spring to call this method and register the returned object 
     * as a bean in the IoC container.
     * Use this when you need to configure an object (like a library class) 
     * that you can't add @Component to.
     */
    @Bean
    public MyCustomObject customBean() {
        return new MyCustomObject("Initialized via @Bean in ProjectConfig!");
    }
}
