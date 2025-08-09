package com.booking.Uber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.Uber.entity.Uber;
import com.booking.Uber.service.UberService;

@RestController
@RequestMapping("uber")
public class UberController {

	@Autowired
	private UberService uberService;
	
	@PostMapping
	void save(@RequestBody Uber uber)
	{
		uberService.save(uber);
		
		
	}
}
