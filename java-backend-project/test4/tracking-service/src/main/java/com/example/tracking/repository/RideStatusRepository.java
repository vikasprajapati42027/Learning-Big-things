package com.example.tracking.repository;

import com.example.tracking.model.RideStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideStatusRepository extends JpaRepository<RideStatus, Long> {
}
