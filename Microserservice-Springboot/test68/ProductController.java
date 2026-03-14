package com.example.mongo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Product create(@RequestBody Product p) { return repo.save(p); }

    @GetMapping
    public List<Product> getAll() { return repo.findAll(); }

    @GetMapping("/category/{cat}")
    public List<Product> byCategory(@PathVariable String cat) {
        return repo.findByCategory(cat);
    }
}
