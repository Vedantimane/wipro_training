package com.backend.order_ms.service;

import com.backend.order_ms.dto.CartDTO;
import com.backend.order_ms.entity.Cart;

public interface CartService {
	 Cart addToCart(CartDTO cartDTO);
	    Cart getCartByUserId(int userId);
	    void removeFromCart(int userId, int productId);
	    void clearCart(int userId);
}
