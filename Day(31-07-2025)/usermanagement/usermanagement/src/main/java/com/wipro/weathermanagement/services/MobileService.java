package com.wipro.weathermanagement.services;

import java.util.List;

import com.wipro.weathermanagement.dto.Mobile;

public interface MobileService {
	
	 void saveMobile(Mobile mobile);             // Create

	    Mobile getMobileById(int id);               // Read

	    String updateMobile(int id, Mobile mobile); // Update

	    String deleteMobile(int id);                // Delete

	    

}
