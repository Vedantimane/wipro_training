package com.wipro.oops.testing;

import com.wipro.oops.HumanBeing;

public class AnimalTesting {
    public static void main(String[] args) {
        HumanBeing human1 = new HumanBeing();
        human1.setName("sita");
        human1.setAge(60);
        human1.setSize(45.4f);
        human1.setGender("Female");

        human1.eating("vegetables");
        human1.drinking("colddrink");
        human1.sleep();

        System.out.println(human1);
    }
}
