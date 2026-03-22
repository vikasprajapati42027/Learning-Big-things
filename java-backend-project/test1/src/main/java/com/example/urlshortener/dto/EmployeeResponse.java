package com.example.urlshortener.dto;

import java.time.Instant;

public record EmployeeResponse(Long id, String name, String email, String department, Instant createdAt) { }
