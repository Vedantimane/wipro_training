package com.wipro.springbootdemo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("hello")
	public String hellowirld(Model model) {
		model.addAttribute("name", "vedanti");
		return "index";
		
	}

}
