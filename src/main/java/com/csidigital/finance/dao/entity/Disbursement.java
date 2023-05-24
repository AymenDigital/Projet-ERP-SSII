package com.csidigital.finance.dao.entity;

import com.csidigital.finance.shared.enumeration.InvoiceEtat;
import com.csidigital.finance.shared.enumeration.TreasuryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disbursement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String category;
    private String invoiceNumber ;
    private Long amount ;
    private Date date ;
    private String description;
    @Enumerated(EnumType.STRING)
    private TreasuryType TreasuryType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billId", referencedColumnName = "id")
    private Bill bill;

    @PrePersist
    public void updateInvoiceEtat() {
        if (bill != null) {
            Bill billObject = bill;
            if (billObject != null) {
                billObject.setInvoiceEtat(InvoiceEtat.En_COURS);
                if (billObject.getTotalWithDiscount() != amount) {
                    throw new IllegalArgumentException("TotalWithDiscount in Bill does not match the amount in Disbursement.");
                    // Ou afficher un message d'erreur
                    // System.out.println("TotalWithDiscount in Bill does not match the amount in Disbursement.");
                }
            }
        }
    }





}
