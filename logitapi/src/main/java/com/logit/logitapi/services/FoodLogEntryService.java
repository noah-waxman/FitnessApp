package com.logit.logitapi.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logit.logitapi.entities.Food;
import com.logit.logitapi.entities.FoodLogEntry;
import com.logit.logitapi.entities.FoodServingUnit;
import com.logit.logitapi.entities.User;
import com.logit.logitapi.exceptions.UserNotFoundException;
import com.logit.logitapi.repositories.FoodLogEntryRepo;
import com.logit.logitapi.repositories.FoodRepo;
import com.logit.logitapi.repositories.FoodServingUnitRepo;
import com.logit.logitapi.repositories.UserRepo;
import com.logit.logitapi.requests.CreateFoodLogEntryRequest;
import com.logit.logitapi.responses.FoodLogEntryResponse;

@Service
public class FoodLogEntryService {
    @Autowired
    private FoodRepo foodRepo;

    @Autowired
    private FoodServingUnitRepo foodServingUnitRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FoodLogEntryRepo foodLogEntryRepo;

    public List<FoodLogEntry> findAll() {
        return foodLogEntryRepo.findAll();
    }

    public FoodLogEntryResponse createFoodLogEntry(CreateFoodLogEntryRequest request) {
        User user = userRepo.findById(request.getUserId()).orElseThrow(
            () -> new UserNotFoundException("User Not Found")
        );

        FoodLogEntry entry = new FoodLogEntry();
        entry.setUser(user);
        entry.setLogDate(request.getLogDate());
        entry.setMealType(request.getMealType());

        if (request.getFoodId() != null) {
            Food food = foodRepo.findById(request.getFoodId()).orElseThrow(
                () -> new IllegalArgumentException("Food Not Found")
            );
            FoodServingUnit unit = foodServingUnitRepo.findById(request.getServingUnitId()).orElseThrow(
                () -> new IllegalArgumentException("Serving Unit Not Found")
            );

            entry.setFood(food);
            entry.setFoodServingUnit(unit);
            entry.setDescription(food.getName());
            entry.setUnitName(unit.getUnitName());
            entry.setQuantity(request.getQuantity());

            entry.setCalories(multiply(request.getQuantity(), unit.getCaloriesPerUnit()));
            entry.setProtein(multiply(request.getQuantity(), unit.getProteinPerUnit()));
            entry.setCarbs(multiply(request.getQuantity(), unit.getCarbsPerUnit()));
            entry.setFat(multiply(request.getQuantity(), unit.getFatPerUnit()));
        } else {
            entry.setDescription(request.getDescription());
            entry.setCalories(request.getCalories());
            entry.setProtein(request.getProtein());
            entry.setCarbs(request.getCarbs());
            entry.setFat(request.getFat());
        }

        FoodLogEntry saved = foodLogEntryRepo.save(entry);

        return new FoodLogEntryResponse(
            saved.getId(),
            saved.getLogDate(),
            saved.getMealType(),
            saved.getFood() != null ? saved.getFood().getId() : null,
            saved.getFoodServingUnit() != null ? saved.getFoodServingUnit().getId() : null,
            saved.getDescription(),
            saved.getQuantity(),
            saved.getUnitName(),
            saved.getCalories(),
            saved.getProtein(),
            saved.getCarbs(),
            saved.getFat()
        );
    }

    // Returns null if the unit has no value for this nutrient
    private BigDecimal multiply(BigDecimal quantity, BigDecimal perUnit) {
        return perUnit == null ? null : quantity.multiply(perUnit);
    }
}