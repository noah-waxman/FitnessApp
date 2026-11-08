package com.logit.logitapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.logit.logitapi.entities.User;
import com.logit.logitapi.requests.CreateUserRequest;
import com.logit.logitapi.services.UserService;
import com.logit.logitapi.requests.CreateUserRequest;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@RequestBody CreateUserRequest request) {
        return userService.createUser(request.getEmail(), request.getPassword());
    }
}


