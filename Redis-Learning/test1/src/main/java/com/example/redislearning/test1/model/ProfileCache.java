package com.example.redislearning.test1.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.Map;

public class ProfileCache {
    @NotBlank
    private String id;

    @NotBlank
    private String name;

    @Email
    private String email;

    private Instant lastUpdated;

    private Map<String, String> metadata;

    public ProfileCache() {
        // Jackson
    }

    public ProfileCache(String id, String name, String email, Instant lastUpdated, Map<String, String> metadata) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastUpdated = lastUpdated;
        this.metadata = metadata;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Instant getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(Instant lastUpdated) { this.lastUpdated = lastUpdated; }
    public Map<String, String> getMetadata() { return metadata; }
    public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }

    @Override
    public String toString() {
        return "ProfileCache{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
