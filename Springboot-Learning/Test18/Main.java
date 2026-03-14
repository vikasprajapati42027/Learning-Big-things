package Test18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Custom Security Configuration.
 * In modern Spring Security, we use a SecurityFilterChain bean.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * (Simulated Config)
 * 
 * @Configuration
 * @EnableWebSecurity
 * public class SecurityConfig {
 *     @Bean
 *     public SecurityFilterChain filterChain(HttpSecurity http) {
 *         http
 *             .authorizeHttpRequests(auth -> auth
 *                 .requestMatchers("/public/**").permitAll()
 *                 .anyRequest().authenticated()
 *             )
 *             .formLogin(Customizer.withDefaults()); // Enables Form login
 *         return http.build();
 *     }
 * }
 */
