package com.example.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class ServiceData {
    @Id @GeneratedValue
    private Long id;
    private String info;
    // Getters and Setters
}

@Repository
public interface DataRepository extends JpaRepository<ServiceData, Long> {
}
