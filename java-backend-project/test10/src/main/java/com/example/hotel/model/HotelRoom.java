package com.example.hotel.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "rooms")
public class HotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hotelName;
    private String roomType; // STANDARD, DELUXE, SUITE
    private BigDecimal pricePerNight;
    private int totalRooms;
    private int availableRooms;

    @Version
    private Long version;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getHotelName() { return hotelName; }
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }
    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    public BigDecimal getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(BigDecimal pricePerNight) { this.pricePerNight = pricePerNight; }
    public int getTotalRooms() { return totalRooms; }
    public void setTotalRooms(int totalRooms) { this.totalRooms = totalRooms; }
    public int getAvailableRooms() { return availableRooms; }
    public void setAvailableRooms(int availableRooms) { this.availableRooms = availableRooms; }
    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }
}
