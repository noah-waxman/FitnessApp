package com.logit.logitapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.logit.logitapi.entities.FoodServingUnit;
import com.logit.logitapi.entities.Food;
import com.logit.logitapi.requests.CreateFoodServingUnitRequest;
import com.logit.logitapi.requests.CreateFoodsRequest;
import com.logit.logitapi.requests.CreateUserRequest;
import com.logit.logitapi.services.FoodServingUnitService;
import com.logit.logitapi.services.FoodService;

@RestController 
@RequestMapping("/food_serving_unit")
public class FoodServingUnitController {
    @Autowired 
    private FoodServingUnitService foodServingUnitService;

    @GetMapping("/getAll")
    public List<FoodServingUnit> getAllUsers() {
        return foodServingUnitService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FoodServingUnit create(@RequestBody CreateFoodServingUnitRequest request) {
        return foodServingUnitService.createFoodServingUnit(
            request.getFoodId(),
            request.getUnitName(),
            request.getCaloriesPerUnit(),
            request.getProteinPerUnit(),
            request.getCarbsPerUnit(),
            request.getFatPerUnit(),
            request.getGramsPerUnit(),
            request.getIsDefault()
        );
    }
    }
