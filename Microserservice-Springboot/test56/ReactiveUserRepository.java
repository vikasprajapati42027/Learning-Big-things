package com.example.r2dbc;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveUserRepository extends ReactiveCrudRepository<User, Long> {
    // Non-blocking database access
}

class User {
    private Long id;
    private String username;
    // Getters/Setters
}
