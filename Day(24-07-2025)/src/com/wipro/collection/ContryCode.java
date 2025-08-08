package com.wipro.collection;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.*;

public class ContryCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, String> contry = new TreeMap();
		contry.put("IN", "India");
		contry.put("US", "United States");
		contry.put("JP", "Japan");
		contry.put("FR", "France");
		
		for(Map.Entry<String, String> data: contry.entrySet()){
			System.out.println(data.getKey()+"- "+data.getValue());
			
		}

	}

}
