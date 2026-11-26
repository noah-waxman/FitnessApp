package com.logitapi.dtos;

import com.logitapi.entities.User;

public record UserResponse(Long id, String email) {
    public static UserResponse from(User u) {
        return new UserResponse(u.getId(), u.getEmail());
    }
}
