package com.backend.food_ms.service;

import java.util.List;
import java.util.Optional;

import com.backend.food_ms.entity.Food;

public interface FoodService {
    Food save(Food food);
    Food updateFood(Food food);   // ✅ takes only Food object
    void deleteFood(Long id);
    Optional<Food> getFoodById(Long id);
    List<Food> getAllFoods();
}
