package com.example.driver.model;

import jakarta.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String vehicle;
    private String status; // AVAILABLE, BUSY

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getVehicle() { return vehicle; }
    public void setVehicle(String vehicle) { this.vehicle = vehicle; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
