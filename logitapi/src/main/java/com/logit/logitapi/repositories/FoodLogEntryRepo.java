package com.logit.logitapi.repositories;

import com.logit.logitapi.entities.Food;
import com.logit.logitapi.entities.FoodLogEntry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodLogEntryRepo extends JpaRepository<FoodLogEntry, Long> {
}