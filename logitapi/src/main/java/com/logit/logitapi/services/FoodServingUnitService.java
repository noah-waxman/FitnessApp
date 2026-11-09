package com.logit.logitapi.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logit.logitapi.entities.FoodServingUnit;
import com.logit.logitapi.entities.Food;
import com.logit.logitapi.entities.User;
import com.logit.logitapi.exceptions.FoodNotFoundException;
import com.logit.logitapi.exceptions.UserNotFoundException;
import com.logit.logitapi.repositories.FoodServingUnitRepo;
import com.logit.logitapi.repositories.FoodRepo;
import com.logit.logitapi.repositories.UserRepo;

@Service 
public class FoodServingUnitService {
    @Autowired
    private FoodRepo foodRepo;

    @Autowired
    private FoodServingUnitRepo foodServingUnitRepo;

    public List<FoodServingUnit> findAll() {
        return foodServingUnitRepo.findAll();
    }

    public FoodServingUnit createFoodServingUnit(
        Long foodId,
        String unitName,
        BigDecimal caloriesPerUnit,
        BigDecimal proteinPerUnit,
        BigDecimal carbsPerUnit,
        BigDecimal fatPerUnit,
        BigDecimal gramsPerUnit,
        Boolean isDefault
    ) {
        Food food = foodRepo.findById(foodId).orElseThrow(
            () -> new FoodNotFoundException("Food not found")
        );

        FoodServingUnit foodServingUnit = new FoodServingUnit();

        foodServingUnit.setFood(food);
        foodServingUnit.setUnitName(unitName);
        foodServingUnit.setCaloriesPerUnit(caloriesPerUnit);
        foodServingUnit.setProteinPerUnit(proteinPerUnit);
        foodServingUnit.setCarbsPerUnit(carbsPerUnit);
        foodServingUnit.setFatPerUnit(fatPerUnit);
        foodServingUnit.setGramsPerUnit(gramsPerUnit);
        foodServingUnit.setIsDefault(isDefault);

        return foodServingUnitRepo.save(foodServingUnit);
    }
}
