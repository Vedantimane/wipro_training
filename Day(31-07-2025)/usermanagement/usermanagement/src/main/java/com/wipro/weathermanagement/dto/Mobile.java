package com.wipro.weathermanagement.dto;

public class Mobile {
	
	int mobileid;
	String make;
	String modelNumber;
	double price;
	
	
	public Mobile() {
		super();
	}


	public Mobile(int mobileid, String make, String modelNumber, double price) {
		super();
		this.mobileid = mobileid;
		this.make = make;
		this.modelNumber = modelNumber;
		this.price = price;
	}


	public int getMobileid() {
		return mobileid;
	}


	public void setMobileid(int mobileid) {
		this.mobileid = mobileid;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModelNumber() {
		return modelNumber;
	}


	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Mobile [mobileid=" + mobileid + ", make=" + make + ", modelNumber=" + modelNumber + ", price=" + price
				+ "]";
	}


	
	
	
}
