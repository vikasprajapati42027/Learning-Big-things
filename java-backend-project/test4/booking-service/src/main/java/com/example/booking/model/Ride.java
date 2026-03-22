package com.example.booking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rides")
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long riderId;
    private String pickup;
    private String dropoff;
    private String status; // REQUESTED, ASSIGNED, IN_PROGRESS, COMPLETED

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getRiderId() { return riderId; }
    public void setRiderId(Long riderId) { this.riderId = riderId; }
    public String getPickup() { return pickup; }
    public void setPickup(String pickup) { this.pickup = pickup; }
    public String getDropoff() { return dropoff; }
    public void setDropoff(String dropoff) { this.dropoff = dropoff; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
