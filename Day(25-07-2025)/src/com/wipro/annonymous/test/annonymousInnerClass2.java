package com.wipro.annonymous.test;

import com.wipro.annonymous.BankOps;

public class annonymousInnerClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankOps CurrentAccount = new BankOps() {
			
			@Override
			public void deposit(double amount) {
				// TODO Auto-generated method stub
				System.out.println("this is current account with :"+ amount+"Rs");
			}
		};
		CurrentAccount.deposit(200);;
	}
	

}
