package com.wipro.annonymous.test;

import com.wipro.annonymous.BankOps;

public class annonymousInnerClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankOps savingaccount = new BankOps() {
			
			@Override
			public void deposit(double amount) {
				// TODO Auto-generated method stub
				System.out.println("this is saving account with :"+ amount+"Rs");
			}
			
		
			
		};
		savingaccount.deposit(100);

	}

}
