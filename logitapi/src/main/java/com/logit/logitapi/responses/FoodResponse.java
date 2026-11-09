package com.logit.logitapi.responses;

import java.math.BigDecimal;

public record FoodResponse(
    Long id,
    String name,
    String brand,
    BigDecimal caloriesPerGram,
    BigDecimal proteinPerGram,
    BigDecimal carbsPerGram,
    BigDecimal fatPerGram
) {}
