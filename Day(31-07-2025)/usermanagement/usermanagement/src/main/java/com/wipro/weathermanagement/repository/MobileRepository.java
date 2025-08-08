package com.wipro.weathermanagement.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import com.wipro.weathermanagement.dto.Mobile;

@Repository
public class MobileRepository {
	
	List<Mobile> mobilelist = new CopyOnWriteArrayList<>();
	
	public void save(Mobile mobile) {
		System.out.println("mobile list added");
		mobilelist.add(mobile);
		
	}
	
	public Mobile findById(int id) {
		for(Mobile mobile:mobilelist) {
			if(mobile.getMobileid()==id) {
				System.out.println("mobile found");
				return mobile;
			}
		}
		System.out.println("Mobile not found.");
		return null;
			}
	
	public String update(int id, Mobile updatedMobile) {
		for (int i = 0; i < mobilelist.size(); i++) {
			if (mobilelist.get(i).getMobileid() == id) {
				mobilelist.set(i, updatedMobile);
				return "Mobile with ID " + id + " updated successfully.";
			}
		}
		return "Mobile with ID " + id + " not found.";
	}
	
	public String delete(int id) {
		for (Mobile mobile : mobilelist) {
			if (mobile.getMobileid() == id) {
				mobilelist.remove(mobile);
				return "mobile deleted";
			}
		}
		return  "mobile not deleted";
	}

}
