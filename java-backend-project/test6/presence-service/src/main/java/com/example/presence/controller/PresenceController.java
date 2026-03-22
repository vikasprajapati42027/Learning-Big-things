package com.example.presence.controller;

import com.example.presence.model.Presence;
import com.example.presence.service.PresenceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/presence")
public class PresenceController {
    private final PresenceService presenceService;

    public PresenceController(PresenceService presenceService) {
        this.presenceService = presenceService;
    }

    @GetMapping("/{username}")
    public Optional<Presence> get(@PathVariable String username) {
        return presenceService.get(username);
    }
}
