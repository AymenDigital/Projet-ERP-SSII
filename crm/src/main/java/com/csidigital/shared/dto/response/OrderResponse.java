package com.csidigital.shared.dto.response;

import com.csidigital.shared.enumeration.BillingType;
import com.csidigital.shared.enumeration.OrderStatus;
import com.csidigital.shared.enumeration.PaymentCondition;
import com.csidigital.shared.enumeration.PaymentMode;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderResponse {
    private Long id ;
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
