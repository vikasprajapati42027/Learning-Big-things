package com.example.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Test3_Authorization {

    // Only ADMIN can access
    @GetMapping("/admin/stats")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminStats() {
        return "Sensitive admin statistics";
    }

    // ADMIN or MANAGER
    @GetMapping("/reports")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public String getReports() {
        return "Monthly reports";
    }

    // Check a specific permission
    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasAuthority('DELETE_USERS')")
    public String deleteUser(@PathVariable int id) {
        return "User " + id + " deleted";
    }

    // Get currently logged-in user
    @GetMapping("/me")
    public String currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "Logged in as: " + auth.getName() + " | Roles: " + auth.getAuthorities();
    }
}
