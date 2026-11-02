package com.logit.logitapi.entities;

import jakarta.persistence.*;
import org.mindrot.jbcrypt.BCrypt;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Users")
public class Users {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is required")
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false, unique = true)
    private String passwordHash;

    public Users () {}

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String password) {
        String secureHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        this.passwordHash = secureHash;
    }
}
