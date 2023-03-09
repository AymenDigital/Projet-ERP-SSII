package com.csidigital.dao.entity;

import com.csidigital.shared.enumeration.BillingType;
import com.csidigital.shared.enumeration.OrderStatus;
import com.csidigital.shared.enumeration.PaymentCondition;
import com.csidigital.shared.enumeration.PaymentMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderRef;
    private OrderStatus orderStatus;
    private Boolean customerAgreement;
    private LocalDate orderDate;
    private BillingType billingType;
    private String billingInstruction;
    private Long tva;
    private PaymentCondition paymentCondition;
    private PaymentMode paymentMode;
    private String bankDetail;
    private Long orderRevenue;

}
