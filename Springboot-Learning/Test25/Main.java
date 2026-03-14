package Test25;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Caching:
 * Avoiding expensive calculations or database calls 
 * by storing the results in memory.
 */
@SpringBootApplication
@EnableCaching
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Service
class ProductService {

    @Cacheable("products")
    public String getProductDetails(String productId) {
        System.out.println("ProductService: fetching details for " + productId + " (Simulating slow DB call)");
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        return "Details for Product: " + productId;
    }
}

@Component
class CacheRunner implements CommandLineRunner {
    private final ProductService productService;

    public CacheRunner(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        System.out.println("1st call: " + productService.getProductDetails("101"));
        System.out.println("2nd call (should be instant): " + productService.getProductDetails("101"));
    }
}
