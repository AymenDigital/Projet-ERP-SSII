package com.csidigital.finance.shared.dto.Response;

import com.csidigital.finance.dao.entity.FeeClient;
import com.csidigital.finance.shared.enumeration.Currency;
import com.csidigital.finance.shared.enumeration.InvoiceEtat;
import com.csidigital.finance.shared.enumeration.InvoiceType;
import com.csidigital.finance.shared.enumeration.PaymentMethod;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class BillClientDtoResponse {

    private Long id;

    @NotBlank(message = "Invoice number cannot be blank.")
    @Column(unique = true)
    private String invoiceNumber;

    private Date date ;

    private Date dueDate;

    private String orderNumber ;

    private com.csidigital.finance.shared.enumeration.PaymentMethod PaymentMethod ;

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

    @Lob
    private String logo ;
    // private Long treasuryId ;

    private List<FeeClient> feeClients ;
}
