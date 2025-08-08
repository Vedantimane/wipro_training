package com.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.demo.services.ContryService;

@Controller
@RequestMapping("/contry")
public class ContryController {
	
	@Autowired
	ContryService contryService;
	
	@GetMapping("/list")
	public String getContryList(Model model) {
		model.addAttribute("contrylist", contryService.getContryList());
		return "contrylist"; // refers to contrylist.jsp
	}
}
