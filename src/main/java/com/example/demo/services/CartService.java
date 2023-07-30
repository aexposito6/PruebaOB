package com.example.demo.services;

import com.example.demo.models.Cart;
import com.example.demo.models.Product;
import com.example.demo.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    public Cart createCart() {
        Cart cart = new Cart();
        cart.setLastActiveDateTime(LocalDateTime.now());
        return cartRepository.save(cart);
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    public Cart addProductToCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart Not Found"));

        Product p = productService.findById(productId);

        if (p != null) {
            cart.getProducts().add(p);
            cart.setLastActiveDateTime(LocalDateTime.now());
            return cartRepository.save(cart);
        }

        return null;

    }

    public void deleteCart(Long cartId) {
        Cart c = cartRepository.findById(cartId).orElse(null);

        if (c != null) {
            cartRepository.deleteById(cartId);
        }
    }
}
