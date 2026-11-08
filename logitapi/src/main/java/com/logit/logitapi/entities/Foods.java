package com.logit.logitapi.entities;

import java.time.Instant;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name="Foods")
public class Foods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String brand;

    @Column(nullable = true)
    private Float caloriesPerGram;

    @Column(nullable = true)
    private Float proteinPerGram;

    @Column(nullable = true)
    private Float carbsPerGram;

    @Column(nullable = true)
    private Float fatPerGram;

    @Column
    private Boolean isArchived = false;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Float getCaloriesPerGram() {
        return caloriesPerGram;
    }

    public void setCaloriesPerGram(Float caloriesPerGram) {
        this.caloriesPerGram = caloriesPerGram;
    }

    public Float getProteinPerGram() {
        return proteinPerGram;
    }

    public void setProteinPerGram(Float proteinPerGram) {
        this.proteinPerGram = proteinPerGram;
    }

    public Float getCarbsPerGram() {
        return carbsPerGram;
    }

    public void setCarbsPerGram(Float carbsPerGram) {
        this.carbsPerGram = carbsPerGram;
    }

    public Float getFatPerGram() {
        return fatPerGram;
    }

    public void setFatPerGram(Float fatPerGram) {
        this.fatPerGram = fatPerGram;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
