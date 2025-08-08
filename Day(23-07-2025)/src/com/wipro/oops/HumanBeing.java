package com.wipro.oops;

public class HumanBeing extends Animal {

    @Override
    public void eating(String food) {
        System.out.println("HumanBeing can eat " + food);
    }

    @Override
    public void drinking(String drink) {
        System.out.println("HumanBeing can drink " + drink);
    }
}
