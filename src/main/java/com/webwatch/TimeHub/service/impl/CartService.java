package com.webwatch.TimeHub.service.impl;

import org.springframework.stereotype.Service;

import com.webwatch.TimeHub.domain.Cart;
import com.webwatch.TimeHub.repository.CartRepository;
import com.webwatch.TimeHub.service.ICartService;

@Service
public class CartService implements ICartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart findByUserId(Long id) {
        return this.cartRepository.findByUserId(id);
    }

    @Override
    public void deleteById(Long id) {
        this.cartRepository.deleteById(id);
    }

}
