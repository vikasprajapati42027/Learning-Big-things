package com.example.restaurant.controller;

import com.example.restaurant.model.Restaurant;
import com.example.restaurant.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant create(@RequestBody Restaurant restaurant) {
        return restaurantService.create(restaurant);
    }

    @GetMapping
    public List<Restaurant> list() {
        return restaurantService.list();
    }
}
