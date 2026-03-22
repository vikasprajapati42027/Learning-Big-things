package com.example.social.service;

import com.example.social.dto.CreateUserRequest;
import com.example.social.model.User;
import com.example.social.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(CreateUserRequest request) {
        User user = new User();
        user.setHandle(request.getHandle());
        user.setName(request.getName());
        return userRepository.save(user);
    }

    public List<User> list() {
        return userRepository.findAll();
    }
}
