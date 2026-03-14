package com.example.data;

import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface EntityGraphRepo extends JpaRepository<User, Long> {
    
    // ✅ Fetches 'roles' in the same query using a JOIN
    // This prevents N+1 (calling DB 10 times for 10 users' roles)
    @EntityGraph(attributePaths = {"roles", "profile"})
    List<User> findAll();
}
