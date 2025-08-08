package com.wipro.weathermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.weathermanagement.dto.Mobile;
import com.wipro.weathermanagement.services.MobileService;

@RestController
@RequestMapping("/mobile")
public class MobileController {
	
	@Autowired
   MobileService mobileService;
	
	@PostMapping
    public String saveMobile(@RequestBody Mobile mobile) {
        mobileService.saveMobile(mobile);
        return "Mobile saved successfully.";
    }
	
	 @GetMapping("/{id}")
	    public Mobile getMobileById(@PathVariable int id) {
	        return mobileService.getMobileById(id);
	    }
	
	 @DeleteMapping("/{id}")
	    public String deleteMobile(@PathVariable int id) {
	        return mobileService.deleteMobile(id);
	    }
	 
	 @PutMapping("/{id}")
	    public String updateMobile(@PathVariable int id, @RequestBody Mobile mobile) {
	        return mobileService.updateMobile(id, mobile);
	    }

}

