package com.letgo.letgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.letgo.letgo.entity.VehicleMovement;


import com.letgo.letgo.service.VehicleService;

@RestController
@RequestMapping("/move") // Optional, makes URL more meaningful
public class VehicleMovementController {
	
    @Autowired
    private VehicleService service;

    @PostMapping
    public VehicleMovement save(@RequestBody VehicleMovement movement) {
        return service.save(movement);
    }
}
