package com.backend.food_ms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.food_ms.entity.Food;
import com.backend.food_ms.service.FoodService;


@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping
    public Food createFood(@RequestBody Food food) {
        System.out.println("Creating food: " + food.getFoodName());
        return foodService.save(food);
    }

    @PutMapping
    public Food updateFood(@RequestBody Food food) {
        System.out.println("Updating food with id: " + food.getFoodId());
        return foodService.updateFood(food);
    }

    @DeleteMapping("/{id}")
    public String deleteFood(@PathVariable Long id) {
        System.out.println("Deleting food with id: " + id);
        foodService.deleteFood(id);
        return "Food deleted with id: " + id;
    }

    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable Long id) {
        System.out.println("Fetching food with id: " + id);
        Optional<Food> food = foodService.getFoodById(id);
        return food.orElse(null); // returns null if not found
    }

    @GetMapping
    public List<Food> getAllFoods() {
        System.out.println("Fetching all foods");
        return foodService.getAllFoods();
    }
}