package com.booking.Uberuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.Uberuser.entity.UberUser;
import com.booking.Uberuser.service.UberUserService;

@RestController
@RequestMapping("/booking")
public class UberUserController {
	
	@Autowired
	UberUserService uberUserService;
	
	@PostMapping
	void pay(@RequestBody UberUser uberUser)
	{
		uberUserService.book(uberUser);;
	}

}
