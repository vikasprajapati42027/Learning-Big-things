package com.example.social.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateUserRequest {
    @NotBlank
    private String handle;
    @NotBlank
    private String name;

    public String getHandle() { return handle; }
    public void setHandle(String handle) { this.handle = handle; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
