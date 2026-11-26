package com.logit.logitapi.repositories;

import com.logit.logitapi.entities.Food;
import com.logit.logitapi.entities.FoodLogEntry;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodLogEntryRepo extends JpaRepository<FoodLogEntry, Long> {
    List<FoodLogEntry> findByUserIdAndLogDate(Long userId, LocalDate logDate);
}