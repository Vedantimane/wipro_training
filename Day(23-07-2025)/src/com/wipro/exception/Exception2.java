package com.wipro.exception;

public class Exception2 {

	public static void main(String[] args) {
		
		try {
			System.out.println(ChangeCurrency(null));
		}catch(RuntimeException ex) {
			System.out.println(ex.getMessage());
		}
		// TODO Auto-generated method stub

	}
	
	static double ChangeCurrency(Double number)throws RuntimeException {
		
		if(number == null) {
			throw new RuntimeException(" Invalid Input");
		}
		return number *80;
	}

}
