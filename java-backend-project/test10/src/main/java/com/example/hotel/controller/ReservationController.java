package com.example.hotel.controller;

import com.example.hotel.dto.ReservationRequest;
import com.example.hotel.model.Reservation;
import com.example.hotel.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final BookingService service;

    public ReservationController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation reserve(@RequestBody @Valid ReservationRequest request) {
        return service.reserve(request);
    }

    @GetMapping
    public List<Reservation> list() {
        return service.listReservations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> get(@PathVariable Long id) {
        return service.getReservation(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
