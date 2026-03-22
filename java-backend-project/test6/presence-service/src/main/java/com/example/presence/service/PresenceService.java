package com.example.presence.service;

import com.example.presence.model.Presence;
import com.example.presence.repository.PresenceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PresenceService {
    private final PresenceRepository repository;

    public PresenceService(PresenceRepository repository) {
        this.repository = repository;
    }

    public Presence save(Presence presence) { return repository.save(presence); }
    public Optional<Presence> get(String username) { return repository.findById(username); }
}
