package com.example.tracking.controller;

import com.example.tracking.model.RideStatus;
import com.example.tracking.service.TrackingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tracking")
public class TrackingController {
    private final TrackingService trackingService;

    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping("/{rideId}")
    public Optional<RideStatus> get(@PathVariable Long rideId) {
        return trackingService.get(rideId);
    }

    @PostMapping("/{rideId}")
    @ResponseStatus(HttpStatus.OK)
    public RideStatus update(@PathVariable Long rideId,
                             @RequestParam String status,
                             @RequestParam String location) {
        return trackingService.update(rideId, status, location);
    }
}
