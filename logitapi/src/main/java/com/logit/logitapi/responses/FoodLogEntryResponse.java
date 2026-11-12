package com.logit.logitapi.responses;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.logit.logitapi.enums.MealType;

public class FoodLogEntryResponse {
    private Long id;
    private LocalDate logDate;
    private MealType mealType;
    private Long foodId;
    private Long servingUnitId;
    private String description;
    private BigDecimal quantity;
    private String unitName;
    private BigDecimal calories;
    private BigDecimal protein;
    private BigDecimal carbs;
    private BigDecimal fat;

    public FoodLogEntryResponse(Long id, LocalDate logDate, MealType mealType,
            Long foodId, Long servingUnitId, String description,
            BigDecimal quantity, String unitName, BigDecimal calories,
            BigDecimal protein, BigDecimal carbs, BigDecimal fat) {
        this.id = id;
        this.logDate = logDate;
        this.mealType = mealType;
        this.foodId = foodId;
        this.servingUnitId = servingUnitId;
        this.description = description;
        this.quantity = quantity;
        this.unitName = unitName;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    public Long getId() { return id; }
    public LocalDate getLogDate() { return logDate; }
    public MealType getMealType() { return mealType; }
    public Long getFoodId() { return foodId; }
    public Long getServingUnitId() { return servingUnitId; }
    public String getDescription() { return description; }
    public BigDecimal getQuantity() { return quantity; }
    public String getUnitName() { return unitName; }
    public BigDecimal getCalories() { return calories; }
    public BigDecimal getProtein() { return protein; }
    public BigDecimal getCarbs() { return carbs; }
    public BigDecimal getFat() { return fat; }
}