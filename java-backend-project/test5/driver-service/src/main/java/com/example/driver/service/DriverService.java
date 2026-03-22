package com.example.driver.service;

import com.example.driver.model.Driver;
import com.example.driver.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    private final DriverRepository repository;

    public DriverService(DriverRepository repository) {
        this.repository = repository;
    }

    public Driver create(Driver driver) {
        driver.setStatus("AVAILABLE");
        return repository.save(driver);
    }

    public List<Driver> list() { return repository.findAll(); }

    public Optional<Driver> findAvailable() { return repository.findFirstByStatus("AVAILABLE"); }

    public void markBusy(Long driverId) {
        repository.findById(driverId).ifPresent(d -> { d.setStatus("BUSY"); repository.save(d); });
    }
}
