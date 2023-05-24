package com.csidigital.finance.dao.entity;

import com.csidigital.finance.shared.enumeration.Currency;
import com.csidigital.finance.shared.enumeration.InvoiceEtat;
import com.csidigital.finance.shared.enumeration.InvoiceType;
import com.csidigital.finance.shared.enumeration.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"invoiceNumber"}))

public class BillClient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Invoice number cannot be blank.")
    @Column(unique = true)
    private String invoiceNumber;

    private Date date;

    private Date dueDate;

    private String orderNumber;


    private String nameSeller;

    private String addressSeller;

    private String nameBuyer;

    private String addressBuyer;

    private Integer discount;

    private Double totalWithDiscount;

    @Transient
    private Double totalAmount;

    @Lob
    private String logo;

    @Enumerated(EnumType.STRING)
    private PaymentMethod PaymentMethod ;

    @Enumerated(EnumType.STRING)
    private InvoiceEtat invoiceEtat;

    @Enumerated(EnumType.STRING)
    private InvoiceType invoiceType;

    public double getTotalAmount() {
        double total = 0;
        for (FeeClient feeClient : feeClients) {
            total += feeClient.getPriceWithAllTaxIncluded();
        }
        return total;
    }

    public double getTotalWithDiscount() {
        double total = 0;
        for (FeeClient feeClient : feeClients) {
            total += feeClient.getPriceWithAllTaxIncluded();
        }
        double totalWithDiscount = total - (total * discount / 100);
        return totalWithDiscount;
    }

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(mappedBy = "billClient", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<FeeClient> feeClients;

    @OneToOne(mappedBy = "billClient", cascade = CascadeType.ALL)
    private Collection collection;



}
