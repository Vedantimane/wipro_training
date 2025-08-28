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
	FoodRepository foodRepo;

	@Override
	public List<Food> findAll() {
		// TODO Auto-generated method stub
		return foodRepo.findAll();
	}

	@Override
	public void save(Food food) {
		// TODO Auto-generated method stub
		
		foodRepo.save(food);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		foodRepo.deleteById(id);
		
	}

	@Override
	public Food findById(int id) {
		// TODO Auto-generated method stub
		Food existingFood = foodRepo.findById(id).get();
		return existingFood;
	}

	@Override
	public void update(int id, Food food) {
		// TODO Auto-generated method stub
		Food existingFood = foodRepo.findById(id).get();
		if(existingFood.getFoodId() == food.getFoodId()) {
			existingFood.setFoodName(food.getFoodName());
			existingFood.setFoodCategory(food.getFoodCategory());
			existingFood.setFoodimg(food.getFoodimg());
			existingFood.setFoodRating(food.getFoodRating());
			existingFood.setFoodPrice(food.getFoodPrice());
			
		}
		
	}

}