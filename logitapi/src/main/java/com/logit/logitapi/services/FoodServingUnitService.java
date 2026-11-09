package com.logit.logitapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logit.logitapi.entities.FoodServingUnit;
import com.logit.logitapi.entities.Foods;
import com.logit.logitapi.entities.User;
import com.logit.logitapi.exceptions.FoodNotFoundException;
import com.logit.logitapi.exceptions.UserNotFoundException;
import com.logit.logitapi.repositories.FoodServingUnitRepo;
import com.logit.logitapi.repositories.FoodsRepo;
import com.logit.logitapi.repositories.UserRepo;

@Service 
public class FoodServingUnitService {
    @Autowired
    private FoodsRepo foodsRepo;

    @Autowired
    private FoodServingUnitRepo foodServingUnitRepo;

    public List<FoodServingUnit> findAll() {
        return foodServingUnitRepo.findAll();
    }

    public FoodServingUnit createFoodServingUnit(
        Long foodId,
        String unitName,
        Float caloriesPerUnit,
        Float proteinPerUnit,
        Float carbsPerUnit,
        Float fatPerUnit,
        Float gramsPerUnit,
        Boolean isDefault
    ) {
        Foods food = foodsRepo.findById(foodId).orElseThrow(
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
