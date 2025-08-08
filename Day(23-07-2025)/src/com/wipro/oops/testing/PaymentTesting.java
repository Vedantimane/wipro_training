package com.wipro.oops.testing;

import java.util.Scanner;

import com.wipro.oops.Gpay;
import com.wipro.oops.PaymentMethod;
import com.wipro.oops.PhonePay;

public class PaymentTesting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select 1 for Gpay");
        System.out.println("Select 2 for PhonePay");

        int option = scanner.nextInt();

        PaymentMethod paymMethod = null; 

        if (option==1) {
            paymMethod = new Gpay();
            paymMethod.pay(1000.0);
        } else if (option==2) {
            paymMethod = new PhonePay();
            paymMethod.pay(1000.0);
        } else {
            System.out.println("wrong payment method selected.");
        }

        

        scanner.close();
    }
}
