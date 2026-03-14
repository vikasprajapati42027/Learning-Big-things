package com.example.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class Test16_MethodSecurity {

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN')") // ✅ Only ADMIN can call this
    public String getAdminDashboard() {
        return "Secret Admin Data";
    }

    @GetMapping("/profile/{username}")
    // ✅ Use SpEL (Spring Expression Language) for complex logic
    @PreAuthorize("#username == authentication.name or hasRole('ADMIN')")
    public String getUserProfile(@PathVariable String username) {
        return "Profile for " + username;
    }
}

// In SecurityConfig, you must enable this:
// @EnableMethodSecurity 
