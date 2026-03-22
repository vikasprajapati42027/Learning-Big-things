package com.example.social.controller;

import com.example.social.dto.CreateUserRequest;
import com.example.social.model.User;
import com.example.social.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody @Valid CreateUserRequest request) {
        return userService.create(request);
    }

    @GetMapping
    public List<User> list() {
        return userService.list();
    }
}
