package com.example.rider.repository;

import com.example.rider.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Long> {
}
