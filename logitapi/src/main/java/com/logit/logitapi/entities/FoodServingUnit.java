package com.logit.logitapi.entities;

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
@Table(name = "Food_Serving_Unit")
public class FoodServingUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", nullable = false)
    private Foods food;

    @Column(nullable = false)
    private String unitName;

    @Column(nullable = false)
    private Float caloriesPerUnit;

    @Column(nullable = true)
    private Float proteinPerUnit;

    @Column(nullable = true)
    private Float carbsPerUnit;

    @Column(nullable = true)
    private Float fatPerUnit;

    @Column(nullable = true)
    private Float gramsPerUnit;

    @Column(nullable = false)
    private Boolean isDefault = false;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    public FoodServingUnit() {}

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Foods getFood() {
        return food;
    }

    public void setFood(Foods food) {
        this.food = food;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Float getCaloriesPerUnit() {
        return caloriesPerUnit;
    }

    public void setCaloriesPerUnit(Float caloriesPerUnit) {
        this.caloriesPerUnit = caloriesPerUnit;
    }

    public Float getProteinPerUnit() {
        return proteinPerUnit;
    }

    public void setProteinPerUnit(Float proteinPerUnit) {
        this.proteinPerUnit = proteinPerUnit;
    }

    public Float getCarbsPerUnit() {
        return carbsPerUnit;
    }

    public void setCarbsPerUnit(Float carbsPerUnit) {
        this.carbsPerUnit = carbsPerUnit;
    }

    public Float getFatPerUnit() {
        return fatPerUnit;
    }

    public void setFatPerUnit(Float fatPerUnit) {
        this.fatPerUnit = fatPerUnit;
    }

    public Float getGramsPerUnit() {
        return gramsPerUnit;
    }

    public void setGramsPerUnit(Float gramsPerUnit) {
        this.gramsPerUnit = gramsPerUnit;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}