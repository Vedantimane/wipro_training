package com.wipro.exception.testing;

import com.wipro.exception.InvalidMonthException;

public class InvalidMonthExceptionTesting {

	public static void main(String[] args) {
		try {
			MonthChecking(14);
		}catch(InvalidMonthException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub

	}
	
	public static void MonthChecking(int month) throws InvalidMonthException{
		
		if(month <1 ||month>12) {
			throw new InvalidMonthException("Invalid Month");
		}else {
			System.out.println("correct month");
		}
	}

}
