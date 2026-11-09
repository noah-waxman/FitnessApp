package com.logit.logitapi.repositories;

import com.logit.logitapi.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Long> {
    Food findByName(String name);
}