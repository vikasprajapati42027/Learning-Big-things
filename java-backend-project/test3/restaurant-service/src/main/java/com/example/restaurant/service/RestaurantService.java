package com.example.restaurant.service;

import com.example.restaurant.model.Restaurant;
import com.example.restaurant.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public Restaurant create(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public List<Restaurant> list() {
        return repository.findAll();
    }
}
