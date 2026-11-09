package com.logit.logitapi.requests;

public class CreateFoodServingUnitRequest {
    private Long foodId;
    private String unitName;
    private Float caloriesPerUnit;
    private Float proteinPerUnit;
    private Float carbsPerUnit;
    private Float fatPerUnit;
    private Float gramsPerUnit;
    private Boolean isDefault = false;

    // Getters and Setters

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
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
}