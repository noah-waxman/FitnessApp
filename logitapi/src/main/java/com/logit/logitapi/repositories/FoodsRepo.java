package com.logit.logitapi.repositories;

import com.logit.logitapi.entities.Foods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodsRepo extends JpaRepository<Foods, Long> {
    Foods findByName(String name);
}