package com.example.rider.controller;

import com.example.rider.model.Rider;
import com.example.rider.service.RiderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/riders")
public class RiderController {
    private final RiderService riderService;

    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rider create(@RequestBody Rider rider) { return riderService.create(rider); }

    @GetMapping
    public List<Rider> list() { return riderService.list(); }
}
