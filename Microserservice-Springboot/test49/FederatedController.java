package com.example.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.Map;

@Controller
public class FederatedController {

    @QueryMapping
    public Map<String, Object> productById(@Argument String id) {
        // In a Federated graph, this service provides only 'Product' details.
        // Another service might provide 'Inventory' details for the same ID.
        return Map.of("id", id, "name", "Professional Laptop", "price", 1500);
    }
}
