package com.example.booking.controller;

import com.example.booking.model.Ride;
import com.example.booking.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ride request(@RequestBody Ride ride) { return bookingService.requestRide(ride); }

    @GetMapping
    public List<Ride> list() { return bookingService.list(); }
}
