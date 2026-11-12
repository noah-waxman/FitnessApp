package com.logit.logitapi.repositories;

import com.logit.logitapi.entities.FoodServingUnit;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodServingUnitRepo extends JpaRepository<FoodServingUnit, Long> {
}