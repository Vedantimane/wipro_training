package com.backend.food_ms.service.foodserviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.food_ms.entity.Food;
import com.backend.food_ms.repository.FoodRepository;
import com.backend.food_ms.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food updateFood(Food food) {
        Optional<Food> existingFoodOpt = foodRepository.findById(food.getFoodId());
        if (existingFoodOpt.isPresent()) {
            Food existingFood = existingFoodOpt.get();
            existingFood.setFoodName(food.getFoodName());
            existingFood.setFoodCategory(food.getFoodCategory());
            existingFood.setFoodPrice(food.getFoodPrice());
            existingFood.setFoodRating(food.getFoodRating());
            existingFood.setFoodimg(food.getFoodimg());
            return foodRepository.save(existingFood);
        } else {
            throw new RuntimeException("Food not found with id: " + food.getFoodId());
        }
    }

    @Override
    public void deleteFood(Long id) {
        if (foodRepository.existsById(id)) {
            foodRepository.deleteById(id);
        } else {
            throw new RuntimeException("Food not found with id: " + id);
        }
    }

    @Override
    public Optional<Food> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }
}
