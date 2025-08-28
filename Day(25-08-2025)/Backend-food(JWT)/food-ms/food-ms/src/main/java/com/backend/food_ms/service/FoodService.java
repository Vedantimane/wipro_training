package com.backend.food_ms.service;

import java.util.List;
import java.util.Optional;

import com.backend.food_ms.entity.Food;

public interface FoodService {
	List<Food> findAll();
	void save(Food food);
	void delete(int id);
	Food findById(int id);
	void update(int id, Food food);
}
