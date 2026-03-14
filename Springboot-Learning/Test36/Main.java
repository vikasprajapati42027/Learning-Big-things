package Test36;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Pagination and Sorting:
 * Never fetch thousands of records at once. 
 * Use Pagination to fetch small chunks (pages).
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

interface ProductRepository extends JpaRepository<Product, Long> {
    // Spring handles the Pageable argument automatically
    Page<Product> findByCategory(String category, Pageable pageable);
}

class Product {
    private Long id;
    private String name;
    private String category;
}

/**
 * Usage example (in a Service or Controller):
 * 
 * Pageable pageable = PageRequest.of(0, 10, Sort.by("name").descending());
 * Page<Product> productPage = repository.findAll(pageable);
 * 
 * List<Product> content = productPage.getContent();
 * long totalElements = productPage.getTotalElements();
 * int totalPages = productPage.getTotalPages();
 */
