package com.wipro.oops.testing;

import com.wipro.oops.CityBank;
import com.wipro.oops.HDFCBank;

public class BankTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HDFCBank hdfcBank = new HDFCBank();
		
		hdfcBank.deposit(1000, "452hdfc");
		hdfcBank.withdraw(456, "452hdfc");
		
		CityBank cityBank = new CityBank();
		
		cityBank.deposit(1000, "452city");
		cityBank.withdraw(456, "452city");

	}

}
