package com.example.hotel.repository;

import com.example.hotel.model.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long> {
    List<HotelRoom> findByHotelNameContainingIgnoreCase(String hotelName);
    List<HotelRoom> findByRoomTypeIgnoreCase(String roomType);
}
