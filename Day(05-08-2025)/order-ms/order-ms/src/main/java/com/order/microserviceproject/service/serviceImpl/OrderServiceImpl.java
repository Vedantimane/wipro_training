package com.order.microserviceproject.service.serviceImpl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
 
import com.order.microserviceproject.dto.Payment;
import com.order.microserviceproject.entity.Order;
import com.order.microserviceproject.repository.OrderRepository;
import com.order.microserviceproject.service.OrderService;
import com.order.microserviceproject.service.PaymentConnectService;
 
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
 
import java.util.List;
 
@Service
public class OrderServiceImpl implements OrderService {
 
    @Autowired
    private OrderRepository orderRepository;
 
    @Autowired
    private PaymentConnectService paymentConnectService;
 
    
 
    @Override
    @CircuitBreaker(name="order-cb", fallbackMethod = "handleFallBack")
    public Order save(Order order) {
        order.setOrderStatus("I");
        Order savedOrder = orderRepository.save(order);
 //try{
 
            Payment paymentRequest = new Payment();
            paymentRequest.setOrderId(savedOrder.getId());
            paymentRequest.setPaymentAmount(savedOrder.getOrderValue());
            paymentRequest.setPaymentMode("UPI");
            paymentRequest.setPaymentDescription("Payment for Order " + savedOrder.getId());
            paymentRequest.setPaymentStatus(true);
 
            ResponseEntity<String> paymentResponseEntity = paymentConnectService.doPayment(paymentRequest);
            String paymentResponse = paymentResponseEntity.getBody();
 
            if (paymentResponseEntity.getStatusCode().is2xxSuccessful() &&
                paymentResponse != null &&
                paymentResponse.contains("Saved")) {
                savedOrder.setOrderStatus("P");
            } else {
                savedOrder.setOrderStatus("C");
            }
//        } catch (Exception e) {
//            savedOrder.setOrderStatus("C");
//        }
 
        return orderRepository.save(savedOrder);
    }
 
    @Override
    public List<Order> findAll() {
        List<Order> orders = orderRepository.findAll();
 
        try {
            ResponseEntity<List<Payment>> paymentsResponse = paymentConnectService.getAllPayments();
            List<Payment> allPayments = paymentsResponse.getBody();
 
            for (Order order : orders) {
                Payment matchedPayment = null;
                if (allPayments != null) {
                    matchedPayment = allPayments.stream()
                            .filter(payment -> payment.getOrderId() == order.getId())
                            .findFirst()
                            .orElse(null);
                }
                order.setPayment(matchedPayment);
            }
        } catch (Exception e) {
            orders.forEach(order -> order.setPayment(null));
        }
 
        return orders;
    }
 
    @Override
    public Order findById(int id) {
    	//try{
        Order order = orderRepository.findById(id).orElse(null);
 
        if (order != null) {
   
                ResponseEntity<List<Payment>> paymentsResponse = paymentConnectService.getAllPayments();
                if(paymentsResponse.getStatusCode()==HttpStatus.OK)
                {
                                
	                List<Payment> allPayments = paymentsResponse.getBody();
	
	                Payment matchedPayment = null;
	                if (allPayments != null) {
	                    matchedPayment = allPayments.stream()
	                            .filter(payment -> payment.getOrderId() == order.getId())
	                            .findFirst()
	                            .orElse(null);
	                }
	
	                order.setPayment(matchedPayment);
                }
//            } catch (Exception e) {
//                order.setPayment(null);
//            }
        }
 
        return order;
    }
 
    @Override
    public boolean deleteById(int id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
 
    @Override
    public boolean update(Order order) {
        if (orderRepository.existsById(order.getId())) {
            orderRepository.save(order);
            return true;
        }
        return false;
    }
    
    Order handleFallBack(Order ordder,Throwable t) {
    	System.out.println("system is down");
		
    	return null;
    }
}
 
 