package com.wipro.annonymous.test;
import java.util.function.Consumer;
public class consumerInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Consumer<Integer>  number = (num)->{
			
			if(num %2 !=0) {
				num=num+1;
			}else if(num%2==0){
				num= num+2;
				
			}
			 System.out.println("Result: " + num);
			
		};
		number.accept(20);

	}

}
