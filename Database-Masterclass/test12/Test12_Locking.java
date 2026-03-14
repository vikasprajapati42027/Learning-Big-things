package com.example.db;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Entity
class Product {
    @Id
    private Long id;
    private Integer stock;
    
    @Version // ✅ Optimistic Locking
    private Integer version;
}

@Repository
public class Test12_Locking {
    @PersistenceContext
    EntityManager em;

    // 1. Pessimistic Lock - Locks the row in DB until transaction ends
    @Transactional
    public void pessimisticWrite(Long id) {
        Product p = em.find(Product.class, id, LockModeType.PESSIMISTIC_WRITE);
        p.setStock(p.getStock() - 1);
    }

    // 2. Optimistic Lock - No lock, but fails if version changed
    @Transactional
    public void optimisticWrite(Long id) {
        Product p = em.find(Product.class, id); // Uses @Version automatically
        p.setStock(p.getStock() - 1);
        // If another thread updated this row first, 
        // this will throw OptimisticLockException on commit!
    }
}
