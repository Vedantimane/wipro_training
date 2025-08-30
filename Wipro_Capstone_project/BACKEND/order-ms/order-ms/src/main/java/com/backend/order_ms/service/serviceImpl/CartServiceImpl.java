package com.backend.order_ms.service.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.order_ms.dto.CartDTO;
import com.backend.order_ms.entity.Cart;
import com.backend.order_ms.repository.CartRepository;
import com.backend.order_ms.service.CartService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

	@Autowired
    private final CartRepository cartRepository;

    @Override
    public Cart addToCart(CartDTO cartDTO) {
        Cart cart = cartRepository.findByUserId(cartDTO.getUserId());

        if (cart == null) {
            cart = new Cart();
            cart.setUserId(cartDTO.getUserId());
            cart.setProductQuantityMap(new HashMap<>());
        }

        // merge products
        for (Map.Entry<Integer, Integer> entry : cartDTO.getProductQuantityMap().entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();

            cart.getProductQuantityMap().merge(productId, quantity, Integer::sum);
        }

        // set total amount from DTO (later you can calculate via ProductMS call)
        cart.setTotalAmount(cartDTO.getTotalAmount());

        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartByUserId(int userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public void removeFromCart(int userId, int productId) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart != null && cart.getProductQuantityMap().containsKey(productId)) {
            cart.getProductQuantityMap().remove(productId);
            cartRepository.save(cart);
        }
    }

    @Override
    public void clearCart(int userId) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart != null) {
            cart.getProductQuantityMap().clear();
            cart.setTotalAmount(0);
            cartRepository.save(cart);
        }
    }
}