package com.webwatch.TimeHub.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webwatch.TimeHub.domain.Order;
import com.webwatch.TimeHub.domain.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    public List<OrderDetail> findByOrderId(long id);

    public void deleteByOrder(Order order);
}
