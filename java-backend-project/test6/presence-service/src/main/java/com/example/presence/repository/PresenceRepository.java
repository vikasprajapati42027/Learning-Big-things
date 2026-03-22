package com.example.presence.repository;

import com.example.presence.model.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresenceRepository extends JpaRepository<Presence, String> {
}
