package com.logit.logitapi.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.logit.logitapi.entities.FoodLogEntry;
import com.logit.logitapi.requests.CreateFoodLogEntryRequest;
import com.logit.logitapi.responses.FoodLogEntryResponse;
import com.logit.logitapi.services.FoodLogEntryService;

@RestController
@RequestMapping("/foodLogEntry")
public class FoodLogEntryController {
    @Autowired
    private FoodLogEntryService foodLogEntryService;

    @GetMapping("/getAll")
    public List<FoodLogEntryResponse> getAll() {
        return foodLogEntryService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FoodLogEntryResponse create(@RequestBody CreateFoodLogEntryRequest request) {
        return foodLogEntryService.createFoodLogEntry(request);
    }

    @GetMapping
    public List<FoodLogEntryResponse> getByUserAndDate(
            @RequestParam Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate logDate) {
        return foodLogEntryService.findByUserAndDate(userId, logDate);
    }
}