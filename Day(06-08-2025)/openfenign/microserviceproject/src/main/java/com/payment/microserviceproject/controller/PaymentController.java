package com.payment.microserviceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.payment.microserviceproject.entity.Payment;
import com.payment.microserviceproject.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public String save(@RequestBody Payment payment) {
        paymentService.save(payment);
        return "Payment Saved Successfully";
    }

    @GetMapping
    public List<Payment> findAll() {
        return paymentService.findAll();
    }

    @GetMapping("/{id}")
    public Payment findById(@PathVariable int id) {
        return paymentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id) {
        return paymentService.deleteById(id) ? "Payment Deleted Successfully" : "Payment Not Found";
    }

    @PutMapping
    public String update(@RequestBody Payment payment) {
        return paymentService.update(payment) ? "Payment Updated Successfully" : "Payment Not Found";
    }
}
