package com.backend.user_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.backend.user_ms.dto.Token;
import com.backend.user_ms.entity.User;
import com.backend.user_ms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/saveuser")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully");
        return ResponseEntity.ok(response);
    }


    @PostMapping("/saveadmin")
    public String registerAdmin(@RequestBody User user) {
        return userService.registerAdmin(user);
    }

    // Login endpoint
    @PostMapping("/login")
    public Token login(@RequestBody User user) {
        return userService.login(user);
    }
    
    // Logout endpoint
    @PostMapping("/logout/{userId}")
    public ResponseEntity<Map<String, String>> logout(@PathVariable int userId) {
        boolean result = userService.logout(userId);
        Map<String, String> response = new HashMap<>();
        if (result) {
            response.put("message", "Logout successful");
            return ResponseEntity.ok(response); 
        } else {
            response.put("message", "Logout failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    // Get all users (for testing/admin)
    @GetMapping()
    public List<User> getAllUsers() {
        return userService.findAll();
    }
    
    @GetMapping("/test")
    public String testEndpoint() {
        return "JWT Authentication working!";
    }
}
