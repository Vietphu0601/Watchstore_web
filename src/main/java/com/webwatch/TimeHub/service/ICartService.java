package com.webwatch.TimeHub.service;

import com.webwatch.TimeHub.domain.Cart;

public interface ICartService {
    public Cart findByUserId(Long id);

    public void deleteById(Long id);
}
