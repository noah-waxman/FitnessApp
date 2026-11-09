package com.logit.logitapi.responses;

public record FoodResponse(
    Long id,
    String name,
    String brand,
    Float caloriesPerGram,
    Float proteinPerGram,
    Float carbsPerGram,
    Float fatPerGram
) {}
