package com.example.driver.repository;

import com.example.driver.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findFirstByStatus(String status);
}
