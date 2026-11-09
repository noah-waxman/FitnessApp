package com.logit.logitapi.services;

import com.logit.logitapi.entities.User;
import com.logit.logitapi.exceptions.EmailAlreadyExistsException;
import com.logit.logitapi.exceptions.UserNotFoundException;
import com.logit.logitapi.repositories.UserRepo;
import com.logit.logitapi.responses.UserResponse;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired 
    private UserRepo userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public UserResponse createUser(String email, String rawPassword, String timezone) {
        if (userRepo.existsByEmail(email)) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = new User();
        String secureHash = BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
        user.setEmail(email);
        user.setPasswordHash(secureHash);
        user.setTimezone(timezone);
        userRepo.save(user);

        return new UserResponse(user.getId(), user.getEmail(), user.getTimezone());
    }

    public UserResponse getUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(
            () -> new UserNotFoundException("User Not Found")
        );

        return new UserResponse(user.getId(), user.getEmail(), user.getTimezone());
    }
}


