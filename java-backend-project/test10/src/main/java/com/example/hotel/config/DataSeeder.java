package com.example.hotel.config;

import com.example.hotel.model.HotelRoom;
import com.example.hotel.repository.HotelRoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner seedRooms(HotelRoomRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                HotelRoom r1 = new HotelRoom();
                r1.setHotelName("City Inn");
                r1.setRoomType("STANDARD");
                r1.setPricePerNight(BigDecimal.valueOf(90));
                r1.setTotalRooms(10);
                r1.setAvailableRooms(10);

                HotelRoom r2 = new HotelRoom();
                r2.setHotelName("Sea View");
                r2.setRoomType("DELUXE");
                r2.setPricePerNight(BigDecimal.valueOf(150));
                r2.setTotalRooms(5);
                r2.setAvailableRooms(5);

                repo.save(r1);
                repo.save(r2);
            }
        };
    }
}
