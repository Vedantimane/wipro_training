package com.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.demo.entity.User;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/userreg")
    public String showform(Model model) {
        model.addAttribute("user", new User());
        return "userreg"; 
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user) {
        System.out.println("Name: " + user.getUserName());
        System.out.println("Email: " + user.getUserEmail());
        System.out.println("Phone: " + user.getUserPhone());
        
        return "success";
    }

}
