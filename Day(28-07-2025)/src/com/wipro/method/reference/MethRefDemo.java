package com.wipro.method.reference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethRefDemo {

    public static void main(String[] args) {
        List<String> namelist = Arrays.asList("vedanti", "dilip", "vanita");

       
        List<String> sortedlist = namelist.stream()
                .sorted(String::compareTo) 
                .collect(Collectors.toList());

        System.out.println("Sorted List: " + sortedlist);
    }
}
