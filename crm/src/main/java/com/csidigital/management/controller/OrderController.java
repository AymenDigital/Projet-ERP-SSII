package com.csidigital.management.controller;

import com.csidigital.dao.entity.Order;
import com.csidigital.management.service.implementation.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService ;
@GetMapping("/getOrder")
    public List<Order> Get(){
        return orderService.get();
    }
}
