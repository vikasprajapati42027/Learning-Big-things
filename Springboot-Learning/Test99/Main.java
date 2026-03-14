package Test99;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Conditional Annotations:
 * The reason Spring Boot is "Opinionated". 
 * It only gives you what you need.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Configuration
class MyConfig {

    @Bean
    @ConditionalOnProperty(name = "feature.enabled", havingValue = "true")
    public String premiumService() {
        return "Premium Service Active";
    }
}
/**
 * Other Conditions:
 * 1. @ConditionalOnMissingBean: Only if I didn't define one myself.
 * 2. @ConditionalOnBean: Only if another bean exists.
 * 3. @ConditionalOnExpression: SpEL based logic.
 * 4. @ConditionalOnWebApplication: Only if it's a web app.
 */
