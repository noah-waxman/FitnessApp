package com.logit.logitapi.requests;

import java.math.BigDecimal;

public class CreateFoodsRequest {
    private Long userId;
    private String name;
    private String brand;
    private BigDecimal caloriesPerGram;
    private BigDecimal proteinPerGram;
    private BigDecimal carbsPerGram;
    private BigDecimal fatPerGram;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
