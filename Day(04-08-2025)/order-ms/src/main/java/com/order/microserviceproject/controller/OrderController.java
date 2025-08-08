package com.order.microserviceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.order.microserviceproject.entity.Order;
import com.order.microserviceproject.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // POST - Save Order
    @PostMapping
    public String save(@RequestBody Order order) {
        orderService.save(order);
        return "Order Saved Successfully";
    }

    // GET - Find All Orders
    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    // GET - Find Order by ID (with proper HTTP response)
    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable int id) {
        Order order = orderService.findById(id);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    // DELETE - Delete Order by ID
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id) {
        boolean deleted = orderService.deleteById(id);
        return deleted ? "Order Deleted Successfully" : "Order Not Found";
    }

    // PUT - Update Order
    @PutMapping
    public String update(@RequestBody Order order) {
        boolean updated = orderService.update(order);
        return updated ? "Order Updated Successfully" : "Order Not Found";
    }
}
