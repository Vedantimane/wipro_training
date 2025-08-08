package com.wipro.oops;



public class PhonePay implements PaymentMethod {

	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		System.out.println("payment is done by PhonePay with the amount: "+amount);
	}

}
