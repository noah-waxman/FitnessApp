package com.logitapi.controllers;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.logitapi.dtos.LoginRequest;
import com.logitapi.dtos.LoginResponse;
import com.logitapi.dtos.RegisterRequest;
import com.logitapi.dtos.RegisterResponse;
import com.logitapi.dtos.UserRequest;
import com.logitapi.dtos.UserResponse;
import com.logitapi.entities.User;
import com.logitapi.services.UserService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/auth")
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtEncoder jwtEncoder;
    private final UserService userService;

    public AuthController(AuthenticationManager authManager, JwtEncoder jwtEncoder, UserService userService) {
        this.authManager = authManager;
        this.jwtEncoder = jwtEncoder;
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(@Valid @RequestBody RegisterRequest req) {
        UserRequest createUserRequest = new UserRequest(req.email(), req.password());
        UserResponse u = userService.create(createUserRequest);
        return new RegisterResponse(u);
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest req) {
        Authentication auth = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(req.email(), req.password())
        );

        User user = userService.getByEmail(auth.getName());

        Instant now = Instant.now();
        Instant expiresAt = now.plus(1, ChronoUnit.HOURS);

        JwtClaimsSet claims = JwtClaimsSet.builder()
            .subject(auth.getName())
            .claim("userId", user.getId())
            .issuedAt(now)
            .expiresAt(now.plus(1, ChronoUnit.HOURS))
            .build();
        
            JwsHeader header = JwsHeader.with(MacAlgorithm.HS256).build();
            String token = jwtEncoder.encode(JwtEncoderParameters.from(header, claims)).getTokenValue();
        
        return new LoginResponse(token, "Bearer", ChronoUnit.SECONDS.between(now, expiresAt), UserResponse.from(user)); 
    }
}
