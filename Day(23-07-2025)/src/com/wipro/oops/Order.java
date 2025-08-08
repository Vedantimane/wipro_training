package com.wipro.oops;

public class Order {

	String Orderid;
	int Orderprice;
	int NumberOfOrderItems;
	
	
	//getters and setters
	public String getOrderid() {
		return Orderid;
	}

	public void setOrderid(String orderid) {
		Orderid = orderid;
	}

	public int getOrderprice() {
		return Orderprice;
	}

	public void setOrderprice(int orderprice) {
		Orderprice = orderprice;
	}

	public int getNumberOfOrderItems() {
		return NumberOfOrderItems;
	}

	public void setNumberOfOrderItems(int numberOfOrderItems) {
		NumberOfOrderItems = numberOfOrderItems;
	}

    // contructor
	public Order(String orderid, int orderprice, int numberOfOrderItems) {
		super();
		Orderid = orderid;
		Orderprice = orderprice;
		NumberOfOrderItems = numberOfOrderItems;
	}

	
	//toString
	@Override
	public String toString() {
		return "Order [Orderid=" + Orderid + ", Orderprice=" + Orderprice + ", NumberOfOrderItems=" + NumberOfOrderItems
				+ "]";
	}
	
	
}
