package com.logit.logitapi.services;

import org.springframework.stereotype.Service;

import com.logit.logitapi.entities.User;
import com.logit.logitapi.repositories.UserRepo;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service 
public class AppUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    public AppUserDetailsService(UserRepo repo) { this.userRepo = repo; }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User u = userRepo.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User Not found"));
        return org.springframework.security.core.userdetails.User
            .withUsername(u.getEmail())
            .password(u.getPasswordHash())
            .roles("USER")
            .build();
    }
}