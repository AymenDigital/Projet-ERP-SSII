package com.csidigital.management.service;

import com.csidigital.dao.entity.Order;
import com.csidigital.shared.dto.request.OrderRequest;
import com.csidigital.shared.dto.response.OrderResponse;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order create(Order order);
    List<Order> get();
    Optional<Order> getById(Long id);

    OrderResponse update(OrderRequest orderRequest );

    void delete(Long id);
}
