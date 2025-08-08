package com.order.microserviceproject.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.order.microserviceproject.dto.Payment;

@FeignClient(name = "payment-ms")
public interface PaymentConnectService {

    @PostMapping("/payments")
    ResponseEntity<String> doPayment(@RequestBody Payment payment);

    @GetMapping("/payments")
    ResponseEntity<List<Payment>> getAllPayments();
}
