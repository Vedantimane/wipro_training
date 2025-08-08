package com.wipro.oops;

public class HDFCBank implements BanksOp{

	
	@Override
	public void deposit(double amount, String accNumber) {
		// TODO Auto-generated method stub
		System.out.println(amount+ " is deposting in "+accNumber+ " in HDFC bank");
	}

	@Override
	public double withdraw(double amount, String accNumber) {
		// TODO Auto-generated method stub
		System.out.println(amount+ " is withdrawing in "+accNumber+ " in HDFC bank");
		return amount;
	}

}
