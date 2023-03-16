package com.csidigital.dao.entity;

import com.csidigital.shared.enumeration.BillingType;
import com.csidigital.shared.enumeration.OrderStatus;
import com.csidigital.shared.enumeration.PaymentCondition;
import com.csidigital.shared.enumeration.PaymentMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@Entity
@Table(name = "order_entity")
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderRef;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private Boolean customerAgreement;
    private Date orderDate;
    @Enumerated(EnumType.STRING)
    private BillingType billingType;
    private String billingInstruction;
    private Long tva;
    @Enumerated(EnumType.STRING)
    private PaymentCondition paymentCondition;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    private String bankDetail;
    private Long orderRevenue;


}
