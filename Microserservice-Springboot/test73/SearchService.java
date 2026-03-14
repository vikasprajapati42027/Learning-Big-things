package com.example.search;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchService {

    public List<String> searchInElastic(String query) {
        // Simulating an Elasticsearch 'Fuzzy Search'
        // In real world: NativeSearchQueryBuilder or high-level REST client
        return List.of("Result 1: Microservices", "Result 2: Spring Boot", "Result 3: Architecture");
    }
}
