package com.logit.logitapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.logit.logitapi.entities.Users;
import com.logit.logitapi.requests.CreateUserRequest;
import com.logit.logitapi.services.UsersService;
import com.logit.logitapi.requests.CreateUserRequest;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/getAll")
    public List<Users> getAllUsers() {
        return usersService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Users create(@RequestBody CreateUserRequest request) {
        Users user = new Users();
        user.setEmail(request.getEmail());
        user.setPasswordHash(request.getPassword());
        return usersService.save(user);
    }
}


