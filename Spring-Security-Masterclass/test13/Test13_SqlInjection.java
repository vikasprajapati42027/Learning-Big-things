package com.example.security;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Test13_SqlInjection {
    private final EntityManager em;

    public Test13_SqlInjection(EntityManager em) {
        this.em = em;
    }

    // ❌ VULNERABLE: String concatenation
    public List<?> findInsecure(String username) {
        // If username is "admin' OR '1'='1", they see ALL users!
        return em.createNativeQuery("SELECT * FROM users WHERE username = '" + username + "'")
                 .getResultList();
    }

    // ✅ SAFE: Parameterized Query
    public List<?> findSecure(String username) {
        return em.createQuery("SELECT u FROM User u WHERE u.username = :user")
                 .setParameter("user", username)
                 .getResultList();
    }
}
