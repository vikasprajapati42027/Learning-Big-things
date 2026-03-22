package com.example.tracking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ride_status")
public class RideStatus {
    @Id
    private Long rideId;
    private String status;
    private String location;

    public Long getRideId() { return rideId; }
    public void setRideId(Long rideId) { this.rideId = rideId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
