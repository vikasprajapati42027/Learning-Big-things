package com.example.rider.service;

import com.example.rider.model.Rider;
import com.example.rider.repository.RiderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderService {
    private final RiderRepository repository;

    public RiderService(RiderRepository repository) {
        this.repository = repository;
    }

    public Rider create(Rider rider) { return repository.save(rider); }
    public List<Rider> list() { return repository.findAll(); }
}
