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

import com.logit.logitapi.entities.Food;
import com.logit.logitapi.requests.CreateFoodsRequest;
import com.logit.logitapi.requests.CreateUserRequest;
import com.logit.logitapi.responses.FoodResponse;
import com.logit.logitapi.services.FoodService;

@RestController 
@RequestMapping("/food")
public class FoodController {
    @Autowired 
    private FoodService foodService;

    @GetMapping("/getAll")
    public List<Food> getAllUsers() {
        return foodService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FoodResponse create(@RequestBody CreateFoodsRequest request) {
        return foodService.createFood(
            request.getUserId(),
            request.getName(),
            request.getBrand()
        );
    }
}
