package com.backend.order_ms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.order_ms.dto.CartDTO;
import com.backend.order_ms.entity.Cart;
import com.backend.order_ms.service.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping()
    public Cart addToCart(@RequestBody CartDTO cartDTO) {
        return cartService.addToCart(cartDTO);
    }

    @GetMapping("/{userId}")
    public Cart getCartByUserId(@PathVariable int userId) {
        return cartService.getCartByUserId(userId);
    }

    @DeleteMapping("/{userId}/{productId}")
    public void removeFromCart(@PathVariable int userId, @PathVariable int productId) {
        cartService.removeFromCart(userId, productId);
    }

    @DeleteMapping("/{userId}")
    public void clearCart(@PathVariable int userId) {
        cartService.clearCart(userId);
    }
}