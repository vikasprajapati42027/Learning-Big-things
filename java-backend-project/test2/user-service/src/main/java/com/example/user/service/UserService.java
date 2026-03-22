package com.example.user.service;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }
}
