package com.example.hotel.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreateRoomRequest {
    @NotBlank
    private String hotelName;
    @NotBlank
    private String roomType;
    @NotNull
    private BigDecimal pricePerNight;
    @Min(1)
    private int totalRooms;

    public String getHotelName() { return hotelName; }
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }
    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    public BigDecimal getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(BigDecimal pricePerNight) { this.pricePerNight = pricePerNight; }
    public int getTotalRooms() { return totalRooms; }
    public void setTotalRooms(int totalRooms) { this.totalRooms = totalRooms; }
}
