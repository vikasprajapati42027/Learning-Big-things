package com.example.driver.controller;

import com.example.driver.model.Driver;
import com.example.driver.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) { this.driverService = driverService; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Driver create(@RequestBody Driver driver) { return driverService.create(driver); }

    @GetMapping
    public List<Driver> list() { return driverService.list(); }
}
