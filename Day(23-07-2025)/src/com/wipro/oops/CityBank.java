package com.wipro.oops;

public class CityBank implements BanksOp{
	
	@Override
	public void deposit(double amount, String accNumber) {
		// TODO Auto-generated method stub
		System.out.println(amount+ " is deposting in "+accNumber+ " in City bank");
	}

	@Override
	public double withdraw(double amount, String accNumber) {
		// TODO Auto-generated method stub
		System.out.println(amount+ " is withdrawing in "+accNumber+ " in City bank");
		return amount;
	}

}
