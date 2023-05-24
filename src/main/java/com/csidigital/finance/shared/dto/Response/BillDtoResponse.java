package com.csidigital.finance.shared.dto.Response;

import com.csidigital.finance.dao.entity.AdditionalFee;
import com.csidigital.finance.shared.enumeration.*;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Data
public class BillDtoResponse {
    private Long id;

    @NotBlank(message = "Invoice number cannot be blank.")
    @Column(unique = true)
    private String invoiceNumber;

    private Date date ;

    private Date dueDate;

    private Date issueDate;

    private String orderNumber ;

    private PaymentMethod PaymentMethod ;

    private String nameSeller;

    private String addressSeller;

    private String nameBuyer;

    private String addressBuyer;

    private Integer discount ;

    private Double totalWithDiscount;

    private Double totalAmount;

    private InvoiceEtat InvoiceEtat;

    private InvoiceType InvoiceType;

    private Currency Currency;

    private List<AdditionalFee> additionalFees ;


    // private Long collectionId;

}
