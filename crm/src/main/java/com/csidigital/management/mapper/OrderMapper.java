package com.csidigital.management.mapper;

import com.csidigital.dao.entity.Order;
import com.csidigital.shared.dto.request.OrderRequest;
import com.csidigital.shared.dto.response.OrderResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component

public class OrderMapper {
    public OrderResponse toOrderResponseDto(Order order){
        OrderResponse orderResponse= new OrderResponse();
        BeanUtils.copyProperties(order, orderResponse);
        return orderResponse ;
    }
    public Order toOrder(OrderRequest orderRequest){
        Order order = new Order();
        BeanUtils.copyProperties(orderRequest, order);
        return order;
}}
