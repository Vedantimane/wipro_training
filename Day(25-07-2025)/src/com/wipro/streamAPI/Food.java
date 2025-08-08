package com.wipro.streamAPI;

public class Food {
	
	String FoodName;
	String type;
	int Price;
	@Override
	public String toString() {
		return "Food [FoodName=" + FoodName + ", type=" + type + ", Price=" + Price + "]";
	}
	public String getFoodName() {
		return FoodName;
	}
	public void setFoodName(String foodName) {
		FoodName = foodName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public Food(String foodName, String type, int price) {
		super();
		FoodName = foodName;
		this.type = type;
		Price = price;
	}
	public Food() {
		super();
	}
	
	

}
