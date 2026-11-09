package com.logit.logitapi.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logit.logitapi.entities.Foods;
import com.logit.logitapi.entities.User;
import com.logit.logitapi.exceptions.UserNotFoundException;
import com.logit.logitapi.repositories.FoodsRepo;
import com.logit.logitapi.repositories.UserRepo;
import com.logit.logitapi.responses.FoodResponse;

@Service 
public class FoodsService {
    @Autowired
    private FoodsRepo foodsRepo;

    @Autowired
    private UserRepo userRepo;

    public List<Foods> findAll() {
        return foodsRepo.findAll();
    }

    public FoodResponse createFood(Long userId, String name, String brand, BigDecimal caloriesPerGram, BigDecimal proteinPerGram, BigDecimal carbsPerGram, BigDecimal fatPerGram) {
        User user = userRepo.findById(userId).orElseThrow(
            () -> new UserNotFoundException("User Not Found")
        );
        
        Foods food = new Foods();

        food.setUser(user);

        if (name != null && !name.isBlank()) {
            food.setName(name);
        }

        if (brand != null && !brand.isBlank()) {
            food.setBrand(brand);
        }

        if (caloriesPerGram != null) {
            food.setCaloriesPerGram(caloriesPerGram);
        }

        if (proteinPerGram != null) {
            food.setProteinPerGram(proteinPerGram);
        }

        if (carbsPerGram != null) {
            food.setCarbsPerGram(carbsPerGram);
        }

        if (fatPerGram != null) {
            food.setFatPerGram(fatPerGram);
        }

        foodsRepo.save(food);

        return new FoodResponse(
            food.getId(),
            food.getName(),
            food.getBrand(),
            food.getCaloriesPerGram(),
            food.getProteinPerGram(),
            food.getCarbsPerGram(),
            food.getFatPerGram()
        );
    }
}
