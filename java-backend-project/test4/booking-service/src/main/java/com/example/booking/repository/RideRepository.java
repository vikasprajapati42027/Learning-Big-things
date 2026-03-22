package com.example.booking.repository;

import com.example.booking.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
}
