package com.example.testing;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserService {
    private final UserRepository repo;
    UserService(UserRepository repo) { this.repo = repo; }
    public String getUser(int id) { return repo.findById(id); }
}

interface UserRepository {
    String findById(int id);
}

public class MockitoTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void testGetUser() {
        // Arrange
        MockitoAnnotations.openMocks(this);
        when(userRepository.findById(1)).thenReturn("Vikas");

        // Act
        String result = userService.getUser(1);

        // Assert
        assertEquals("Vikas", result);
        verify(userRepository, times(1)).findById(1);
    }
}
