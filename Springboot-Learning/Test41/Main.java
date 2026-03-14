package Test41;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Spring Boot with Redis:
 * Distributed caching. Unlike the default ConcurrentMap cache, 
 * Redis cache survives application restarts and can be shared 
 * across multiple instances.
 */
@SpringBootApplication
@EnableCaching
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * redis-starter automatically configures a RedisCacheManager 
 * if a Redis connection is available (via application.properties).
 */
