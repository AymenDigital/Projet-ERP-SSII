package com.csidigital.finance.shared.dto.Request;

import com.csidigital.finance.dao.entity.FeeClient;
import com.csidigital.finance.shared.enumeration.Currency;
import com.csidigital.finance.shared.enumeration.InvoiceEtat;
import com.csidigital.finance.shared.enumeration.InvoiceType;
import com.csidigital.finance.shared.enumeration.PaymentMethod;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class BillClientDtoRequest {
    @NotBlank(message = "Invoice number cannot be blank.")
    @Column(unique = true)
    private String invoiceNumber;

    private Date date = new Date();

    private String nameSeller = "csi digital";

    private String addressSeller = "Bizerte";

    private String nameBuyer;

    private String addressBuyer;

    private Integer discount ;

    private Date dueDate;

    private String orderNumber ;


    private InvoiceEtat InvoiceEtat = com.csidigital.finance.shared.enumeration.InvoiceEtat.EN_ATTENTE;

    private com.csidigital.finance.shared.enumeration.InvoiceType InvoiceType;

    private com.csidigital.finance.shared.enumeration.PaymentMethod PaymentMethod ;

    private Currency Currency;

    @Lob
    private String logo ;

    private List<FeeClient> feeClients ;

}
