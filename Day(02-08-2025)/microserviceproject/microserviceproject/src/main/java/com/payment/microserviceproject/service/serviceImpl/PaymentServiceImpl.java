package com.payment.microserviceproject.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.microserviceproject.entity.Payment;
import com.payment.microserviceproject.repository.PaymentRepository;
import com.payment.microserviceproject.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(int id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Payment payment) {
        if (paymentRepository.existsById(payment.getPaymentId())) {
            paymentRepository.save(payment);
            return true;
        }
        return false;
    }
}
