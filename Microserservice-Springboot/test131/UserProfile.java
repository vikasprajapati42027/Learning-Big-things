package com.example.masking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserProfile {

    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String ssn; // Social Security Number - Masked in Responses

    private String email;

    public UserProfile(String name, String ssn, String email) {
        this.name = name;
        this.ssn = ssn;
        this.email = email;
    }

    // Getters
}
// Note: Using @JsonProperty or custom serializers ensures PI (Personal Info) is never leaked.
