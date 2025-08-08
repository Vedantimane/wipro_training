package com.wiproA.mockitdemo;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testApp() {
        assertTrue(true);
    }
    
    @Test
    void orderSerivcetest() {
        OrderService orderService = mock(OrderService.class);
        when(orderService.placeOrder("ORD-01")).thenReturn("successful");
        String str = "successful";
        assertEquals(str, orderService.placeOrder("ORD-01"));

       
    }
}
