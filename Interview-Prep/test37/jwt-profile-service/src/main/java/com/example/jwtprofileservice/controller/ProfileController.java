package com.example.jwtprofileservice.controller;

import com.example.jwtprofileservice.model.AuthRequest;
import com.example.jwtprofileservice.model.AuthResponse;
import com.example.jwtprofileservice.model.Profile;
import com.example.jwtprofileservice.service.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProfileController {
    private final JwtService jwtService;

    public ProfileController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        if (!"profile".equals(request.getUsername()) || !"secure".equals(request.getPassword())) {
            return ResponseEntity.status(401).build();
        }
        String token = jwtService.generateToken(request.getUsername(), "USER");
        return ResponseEntity.ok(new AuthResponse(token, "Bearer"));
    }

    @GetMapping("/profile")
    public ResponseEntity<Profile> profile(HttpServletRequest request) {
        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (auth == null || !auth.startsWith("Bearer ")) {
            return ResponseEntity.status(401).build();
        }
        String token = auth.substring(7);
        Claims claims = jwtService.parseAndValidate(token);
        Profile profile = new Profile(claims.getSubject(), "profile@example.com", Map.of("role", claims.get("role")));
        return ResponseEntity.ok(profile);
    }
}
