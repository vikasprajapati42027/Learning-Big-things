package Test34;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Derived Query Methods:
 * You just write the method name, and Spring generates the SQL.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

interface ProductRepository extends JpaRepository<Product, Long> {

    // SELECT * FROM products WHERE name = ?
    List<Product> findByName(String name);

    // SELECT * FROM products WHERE price > ?
    List<Product> findByPriceGreaterThan(double price);

    // SELECT * FROM products WHERE category = ? AND active = true
    List<Product> findByCategoryAndActiveTrue(String category);

    // SELECT * FROM products WHERE name LIKE %?%
    List<Product> findByNameContaining(String part);
}

class Product {
    private Long id;
    private String name;
    private double price;
    private String category;
    private boolean active;
}
