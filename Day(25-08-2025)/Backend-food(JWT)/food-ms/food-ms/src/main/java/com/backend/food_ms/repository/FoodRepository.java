package com.backend.food_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.food_ms.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

}
