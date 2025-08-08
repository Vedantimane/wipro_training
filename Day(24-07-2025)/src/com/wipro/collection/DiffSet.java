package com.wipro.collection;
import java.util.HashSet;
import java.util.Set;

public class DiffSet {
    public static void main(String[] args) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

       
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

      
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);

        
        Set<Integer> difference = new HashSet<>(set1); 
        difference.removeAll(set2); 

        System.out.println( set1);
        System.out.println( set2);
        System.out.println(difference);
    }
}
