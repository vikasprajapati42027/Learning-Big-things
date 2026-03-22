package com.example.hotel.service;

import com.example.hotel.dto.CreateRoomRequest;
import com.example.hotel.dto.ReservationRequest;
import com.example.hotel.model.HotelRoom;
import com.example.hotel.model.Reservation;
import com.example.hotel.repository.HotelRoomRepository;
import com.example.hotel.repository.ReservationRepository;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final HotelRoomRepository roomRepo;
    private final ReservationRepository resRepo;

    public BookingService(HotelRoomRepository roomRepo, ReservationRepository resRepo) {
        this.roomRepo = roomRepo;
        this.resRepo = resRepo;
    }

    public List<HotelRoom> listRooms(String hotelName, String roomType) {
        if (hotelName != null && !hotelName.isBlank()) {
            return roomRepo.findByHotelNameContainingIgnoreCase(hotelName);
        }
        if (roomType != null && !roomType.isBlank()) {
            return roomRepo.findByRoomTypeIgnoreCase(roomType);
        }
        return roomRepo.findAll();
    }

    public HotelRoom createRoom(CreateRoomRequest req) {
        HotelRoom room = new HotelRoom();
        room.setHotelName(req.getHotelName());
        room.setRoomType(req.getRoomType());
        room.setPricePerNight(req.getPricePerNight());
        room.setTotalRooms(req.getTotalRooms());
        room.setAvailableRooms(req.getTotalRooms());
        return roomRepo.save(room);
    }

    @Transactional
    public Reservation reserve(ReservationRequest req) {
        int retries = 3;
        while (retries-- > 0) {
            try {
                return attemptReservation(req);
            } catch (OptimisticLockingFailureException e) {
                if (retries == 0) throw e;
            }
        }
        throw new IllegalStateException("Could not complete reservation after retries");
    }

    private Reservation attemptReservation(ReservationRequest req) {
        HotelRoom room = roomRepo.findById(req.getRoomId()).orElseThrow();
        if (room.getAvailableRooms() <= 0) {
            throw new IllegalStateException("No availability");
        }
        room.setAvailableRooms(room.getAvailableRooms() - 1);
        roomRepo.save(room);

        Reservation res = new Reservation();
        res.setRoomId(room.getId());
        res.setGuestName(req.getGuestName());
        res.setStartDate(req.getStartDate());
        res.setEndDate(req.getEndDate());
        res.setCreatedAt(OffsetDateTime.now());
        return resRepo.save(res);
    }

    public Optional<Reservation> getReservation(Long id) {
        return resRepo.findById(id);
    }

    public List<Reservation> listReservations() {
        return resRepo.findAll();
    }
}
