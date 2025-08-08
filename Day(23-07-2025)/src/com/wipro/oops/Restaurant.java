package com.wipro.oops;


import java.util.Arrays;

public class Restaurant {
	
	String RestaurantId;
	String Restaurantname;
	String[] restaurantMenu;
	
	//contructor
	public Restaurant(String restaurantId, String restaurantname, String[] restaurantMenu) {
		super();
		RestaurantId = restaurantId;
		Restaurantname = restaurantname;
		this.restaurantMenu = restaurantMenu;
	}
	

	//getters and setters
	public String getRestaurantId() {
		return RestaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		RestaurantId = restaurantId;
	}

	public String getRestaurantname() {
		return Restaurantname;
	}

	public void setRestaurantname(String restaurantname) {
		Restaurantname = restaurantname;
	}

	public String[] getRestaurantMenu() {
		return restaurantMenu;
	}

	public void setRestaurantMenu(String[] restaurantMenu) {
		this.restaurantMenu = restaurantMenu;
	}


	//toString
	@Override
	public String toString() {
		return "Restaurant [RestaurantId=" + RestaurantId + ", Restaurantname=" + Restaurantname + ", restaurantMenu="
				+ Arrays.toString(restaurantMenu) + "]";
	}

	
	
	
}