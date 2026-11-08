package com.logit.logitapi.services;

import com.logit.logitapi.entities.User;
import com.logit.logitapi.exceptions.EmailAlreadyExistsException;
import com.logit.logitapi.repositories.UserRepo;

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

    public User createUser(String email, String rawPassword) {
        if (userRepo.existsByEmail(email)) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = new User();
        String secureHash = BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
        user.setEmail(email);
        user.setPasswordHash(secureHash);
        return userRepo.save(user);
    }
}


