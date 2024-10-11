package com.webwatch.TimeHub.service;

import com.webwatch.TimeHub.domain.Order;
import com.webwatch.TimeHub.domain.OrderDetail;
import com.webwatch.TimeHub.domain.User;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.servlet.http.HttpSession;

public interface IOrderService {
    public Order handlePlaceOrder(User user, HttpSession session, String receiverName, String receiverAddress,
            String receiverPhone);

    public Order findById(Long id);

    public Page<Order> findAll(Pageable pageable);

    public List<OrderDetail> findByOrderId(Long id);

    public Order save(Order order);

    public void deleteById(Long id);

    public void deleteOrderDetailByOrderId(Long id);
}
