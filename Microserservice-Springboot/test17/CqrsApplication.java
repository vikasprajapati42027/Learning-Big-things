package com.example.cqrs;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * CQRS: Splitting Command (Write) and Query (Read)
 */
@RestController
@RequestMapping("/products")
public class OrderCqrsController {

    private final ProductCommandService commandService = new ProductCommandService();
    private final ProductQueryService queryService = new ProductQueryService();

    // COMMAND: Create a product (Writes to MySQL)
    @PostMapping
    public void create(@RequestBody String name) {
        commandService.handleCreate(name);
    }

    // QUERY: Get products (Reads from fast Elasticsearch/Redis)
    @GetMapping
    public List<String> getAll() {
        return queryService.findAll();
    }
}

@Service
class ProductCommandService {
    public void handleCreate(String name) {
        System.out.println("Command: Saving '" + name + "' to Relational DB...");
    }
}

@Service
class ProductQueryService {
    public List<String> findAll() {
        System.out.println("Query: Fetching from fast Read-Only database...");
        return List.of("Phone", "Laptop", "Tablet");
    }
}
