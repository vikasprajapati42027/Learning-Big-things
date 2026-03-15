package com.example.jwtprofileservice.model;

import java.util.Map;

public class Profile {
    private final String username;
    private final String email;
    private final Map<String, Object> attributes;

    public Profile(String username, String email, Map<String, Object> attributes) {
        this.username = username;
        this.email = email;
        this.attributes = attributes;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }
}
