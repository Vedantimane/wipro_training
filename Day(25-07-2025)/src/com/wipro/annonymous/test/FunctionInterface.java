package com.wipro.annonymous.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionInterface {

    public static void main(String[] args) {
    	
    	List<String> words = new ArrayList();
    	words.add("vedu");
    	words.add("vedanti");
    	words.add("mane");
    	
    	Function<List<String>,List<Integer>> wordlength = list ->{
    		List<Integer> length = new ArrayList();
    		for(String word: list ) {
    			length.add(word.length());
    		}
    		return length;
    		
    	};
    	
    	List<Integer> result = wordlength.apply(words);
    	System.out.println(result); 
    	
    	
    	
    	
    	
    	
    	
  
    	
    	
    	
//        Function<Double, Double> convert = num -> num - Math.floor(num);
//
//        double result = convert.apply(123.45);
//        System.out.println(result);  
    }
}
