package com.example.redislearning.test1.controller;

import com.example.redislearning.test1.model.ProfileCache;
import com.example.redislearning.test1.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<ProfileCache> save(@Valid @RequestBody ProfileCache profile) {
        return ResponseEntity.accepted().body(profileService.save(profile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileCache> get(@PathVariable String id) {
        return ResponseEntity.ok(profileService.find(id));
    }
}
