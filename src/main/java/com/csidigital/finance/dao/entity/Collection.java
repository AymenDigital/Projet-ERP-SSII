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
public class Collection implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String category ;
    private String invoiceNumber ;
    private Long amount ;
    private Date date;
    private String description ;
    @Enumerated(EnumType.STRING)
    private TreasuryType treasuryType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billClientId", referencedColumnName = "id")
    private BillClient billClient;

    @PrePersist
    public void updateInvoiceEtat() {
        if (billClient != null) {
            BillClient bill = billClient;
            if (bill != null) {
                bill.setInvoiceEtat(InvoiceEtat.En_COURS);
                if (bill.getTotalWithDiscount() != amount) {
                    throw new IllegalArgumentException("TotalWithDiscount in BillClient does not match the amount in Collection.");
                    // Ou afficher un message d'erreur
                    // System.out.println("TotalWithDiscount in BillClient does not match the amount in Collection.");
                }
            }
        }
    }

}





