package com.logitapi.dtos;

import com.logitapi.entities.User;

public record LoginResponse(String accessToken, String tokenType, long expiresIn, UserResponse user) {
}
