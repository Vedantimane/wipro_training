package com.wipro.streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class FoodStreamAPI {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		Food food1 = new Food("noodles","chinese",560);
		Food food2 = new Food("soup","Chinese",160);
		Food food3 = new Food("roll","chinese",260);
		Food food4 = new Food("puranpoli","Indian",460);
		Food food5 = new Food("vadapav","Indian",60);
		
		List<Food> food = new ArrayList();
		
		food.add(food1);
		food.add(food2);
		food.add(food3);
		food.add(food4);
		food.add(food5);
		
		Comparator<Food> priceComparator = (f1, f2) -> {
		    return Integer.compare(f1.getPrice(), f2.getPrice());
		};


		
	Food list=
			food.stream()
			.filter(foodtype ->foodtype.getType().equalsIgnoreCase("chinese"))
			.sorted(priceComparator.reversed())
			.findFirst().get();

	System.out.println(list);
	}
}

