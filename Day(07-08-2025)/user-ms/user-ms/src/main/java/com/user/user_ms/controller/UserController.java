package com.user.user_ms.controller;

import com.user.user_ms.entity.User;
import com.user.user_ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

  
    @PostMapping
    public String save(@RequestBody User user) {
        userService.save(user);
        return "User Saved Successfully";
    }


    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }


    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id); 
    }

  
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id) {
        boolean deleted = userService.deleteById(id);
        return deleted ? "User Deleted Successfully" : "User Not Found";
    }


    @PutMapping
    public String update(@RequestBody User user) {
        boolean updated = userService.update(user);
        return updated ? "User Updated Successfully" : "User Not Found";
    }
}
