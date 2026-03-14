package com.example.data;

import org.springframework.beans.factory.annotation.Value;

// Interface Projection: Spring only selects specific columns from DB
public interface UserSummary {
    String getUsername();
    
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}

// In Repository:
// List<UserSummary> findByStatus(String status);
