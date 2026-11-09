package com.logit.logitapi.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String brand;

    @Column(nullable = true)
    private BigDecimal caloriesPerGram;

    @Column(nullable = true)
    private BigDecimal proteinPerGram;

    @Column(nullable = true)
    private BigDecimal carbsPerGram;

    @Column(nullable = true)
    private BigDecimal fatPerGram;

    @Column
    private Boolean isArchived = false;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    public Foods () {}

    // Getters and Setters
    
    public Long getId() {
        return id;
    }

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

    public BigDecimal getCaloriesPerGram() {
        return caloriesPerGram;
    }

    public void setCaloriesPerGram(BigDecimal caloriesPerGram) {
        this.caloriesPerGram = caloriesPerGram;
    }

    public BigDecimal getProteinPerGram() {
        return proteinPerGram;
    }

    public void setProteinPerGram(BigDecimal proteinPerGram) {
        this.proteinPerGram = proteinPerGram;
    }

    public BigDecimal getCarbsPerGram() {
        return carbsPerGram;
    }

    public void setCarbsPerGram(BigDecimal carbsPerGram) {
        this.carbsPerGram = carbsPerGram;
    }

    public BigDecimal getFatPerGram() {
        return fatPerGram;
    }

    public void setFatPerGram(BigDecimal fatPerGram) {
        this.fatPerGram = fatPerGram;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
