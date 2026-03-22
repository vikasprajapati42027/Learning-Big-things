package com.example.hotel.controller;

import com.example.hotel.dto.CreateRoomRequest;
import com.example.hotel.model.HotelRoom;
import com.example.hotel.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final BookingService service;

    public RoomController(BookingService service) {
        this.service = service;
    }

    @GetMapping
    public List<HotelRoom> list(@RequestParam(required = false) String hotelName,
                                @RequestParam(required = false) String roomType) {
        return service.listRooms(hotelName, roomType);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HotelRoom create(@RequestBody @Valid CreateRoomRequest request) {
        return service.createRoom(request);
    }
}
