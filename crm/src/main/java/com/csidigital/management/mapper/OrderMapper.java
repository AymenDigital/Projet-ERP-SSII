package com.csidigital.management.mapper;

import com.csidigital.dao.entity.Order;
import com.csidigital.dao.entity.Requirement;
import com.csidigital.shared.dto.request.OrderRequest;
import com.csidigital.shared.dto.request.RequirementRequest;
import com.csidigital.shared.dto.response.OrderResponse;
import com.csidigital.shared.dto.response.RequirementResponse;
import org.springframework.beans.BeanUtils;

public class OrderMapper {
    public OrderResponse toOrderResponseDto(Order order){
        OrderResponse orderResponse= new OrderResponse();
        BeanUtils.copyProperties(order, orderResponse);
        return orderResponse ;
    }
    public Order toOrder(OrderRequest orderRequest){
        Order order= new Order();
        BeanUtils.copyProperties(orderRequest, order);
        return order ;
}}
