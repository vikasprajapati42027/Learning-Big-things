package com.example.db;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.*;

// Test 11: JPA Specifications for dynamic search
public class UserSpecs {

    public static Specification<User> hasName(String name) {
        return (root, query, cb) -> name == null ? null : cb.equal(root.get("name"), name);
    }

    public static Specification<User> hasAgeGreaterThan(Integer age) {
        return (root, query, cb) -> age == null ? null : cb.greaterThan(root.get("age"), age);
    }

    // Usage in Repository:
    // List<User> users = repo.findAll(hasName("Vikas").and(hasAgeGreaterThan(25)));
}
