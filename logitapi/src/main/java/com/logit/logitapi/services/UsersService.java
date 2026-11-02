package com.logit.logitapi.services;

import com.logit.logitapi.entities.Users;
import com.logit.logitapi.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired 
    private UsersRepo usersRepo;

    public List<Users> findAll() {
        return usersRepo.findAll();
    }

    public Users save(Users user) {
        return usersRepo.save(user);
    }
}


