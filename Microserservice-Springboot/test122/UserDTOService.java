package com.example.dto;

import org.springframework.stereotype.Service;
import jakarta.persistence.*;

@Entity
class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String passwordHash; // Should NEVER be exposed in API response!

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}

// Safe response (DTO) - only exposes safe fields
class UserDTO {
    public Long id;
    public String name;
    public String email;

    public static UserDTO from(UserEntity e) {
        UserDTO dto = new UserDTO();
        dto.id = e.getId();
        dto.name = e.getName();
        dto.email = e.getEmail();
        return dto;
    }
}

@Service
public class UserDTOService {
    public UserDTO toSafeDTO(UserEntity e) {
        return UserDTO.from(e);
    }
}
