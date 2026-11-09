package com.logit.logitapi.requests;

import java.math.BigDecimal;

public class CreateFoodServingUnitRequest {
    private Long foodId;
    private String unitName;
    private BigDecimal caloriesPerUnit;
    private BigDecimal proteinPerUnit;
    private BigDecimal carbsPerUnit;
    private BigDecimal fatPerUnit;
    private BigDecimal gramsPerUnit;
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
}