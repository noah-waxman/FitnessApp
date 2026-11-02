package com.logit.logitapi.repositories;

import com.logit.logitapi.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}