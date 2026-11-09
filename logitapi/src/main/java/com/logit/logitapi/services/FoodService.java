package com.logit.logitapi.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logit.logitapi.entities.Food;
import com.logit.logitapi.entities.User;
import com.logit.logitapi.exceptions.UserNotFoundException;
import com.logit.logitapi.repositories.FoodRepo;
import com.logit.logitapi.repositories.UserRepo;
import com.logit.logitapi.responses.FoodResponse;

@Service 
public class FoodService {
    @Autowired
    private FoodRepo foodRepo;

    @Autowired
    private UserRepo userRepo;

    public List<Food> findAll() {
        return foodRepo.findAll();
    }

    public FoodResponse createFood(Long userId, String name, String brand) {
        User user = userRepo.findById(userId).orElseThrow(
            () -> new UserNotFoundException("User Not Found")
        );
        
        Food food = new Food();

        food.setUser(user);

        if (name != null && !name.isBlank()) {
            food.setName(name);
        }

        if (brand != null && !brand.isBlank()) {
            food.setBrand(brand);
        }

        foodRepo.save(food);

        return new FoodResponse(
            food.getId(),
            food.getName(),
            food.getBrand()
        );
    }
}
