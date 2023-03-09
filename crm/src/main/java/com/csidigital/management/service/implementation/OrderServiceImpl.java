package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.Order;
import com.csidigital.shared.dto.request.OrderRequest;
import com.csidigital.shared.dto.response.OrderResponse;
import com.csidigital.dao.repository.OrderRepository;
import com.csidigital.management.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
   @Autowired
   private OrderRepository orderRepository ;
    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> get() {

        return orderRepository.findAll() ;
    }

    @Override
    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public OrderResponse update(OrderRequest orderRequest) {

        /*Order order = orderRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("order with id " +id+ " not found"));
        order.setOrderDate(orderRequest.getOrderDate());
        order.setOrderRevenue(orderRequest.getOrderRevenue());
        order.setOrderStatus(orderRequest.getOrderStatus());
        order.setBankDetail(orderRequest.getBankDetail());
        order.setPaymentMode(orderRequest.getPaymentMode());
        order.setBillingType(orderRequest.getBillingType());
        order.setBillingInstruction(orderRequest.getBillingInstruction());
        order.setCustomerAgreement(orderRequest.getCustomerAgreement());
        order.setPaymentCondition(orderRequest.getPaymentCondition());
        order.setTva(orderRequest.getTva());*/


        return null;
    }

    @Override
    public void delete(Long id) {
     orderRepository.deleteById(id);
    }
}
