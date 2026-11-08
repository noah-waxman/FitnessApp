package com.logit.logitapi.requests;

public class CreateFoodsRequest {
    private Long userId;
    private String name;
    private String brand;
    private Float caloriesPerGram;
    private Float proteinPerGram;
    private Float carbsPerGram;
    private Float fatPerGram;

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
}
