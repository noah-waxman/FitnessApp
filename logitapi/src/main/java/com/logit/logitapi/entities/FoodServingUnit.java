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
    private BigDecimal caloriesPerUnit;

    @Column(nullable = true)
    private BigDecimal proteinPerUnit;

    @Column(nullable = true)
    private BigDecimal carbsPerUnit;

    @Column(nullable = true)
    private BigDecimal fatPerUnit;

    @Column(nullable = true)
    private BigDecimal gramsPerUnit;

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

    public BigDecimal getCaloriesPerUnit() {
        return caloriesPerUnit;
    }

    public void setCaloriesPerUnit(BigDecimal caloriesPerUnit) {
        this.caloriesPerUnit = caloriesPerUnit;
    }

    public BigDecimal getProteinPerUnit() {
        return proteinPerUnit;
    }

    public void setProteinPerUnit(BigDecimal proteinPerUnit) {
        this.proteinPerUnit = proteinPerUnit;
    }

    public BigDecimal getCarbsPerUnit() {
        return carbsPerUnit;
    }

    public void setCarbsPerUnit(BigDecimal carbsPerUnit) {
        this.carbsPerUnit = carbsPerUnit;
    }

    public BigDecimal getFatPerUnit() {
        return fatPerUnit;
    }

    public void setFatPerUnit(BigDecimal fatPerUnit) {
        this.fatPerUnit = fatPerUnit;
    }

    public BigDecimal getGramsPerUnit() {
        return gramsPerUnit;
    }

    public void setGramsPerUnit(BigDecimal gramsPerUnit) {
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