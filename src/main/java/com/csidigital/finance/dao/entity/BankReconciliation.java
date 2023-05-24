package com.csidigital.finance.dao.entity;

import com.csidigital.finance.shared.enumeration.Currency;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class BankReconciliation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long checkNumber;

    private Date issueDate;

    private double Amount;

    private String beneficiary;

    private Long InvoiceNumber;

    private Date CompletionDate;

    @Enumerated(EnumType.STRING)

    private Currency currency;

   // @ManyToOne(fetch = FetchType.EAGER)
  //  @JoinColumn(name = "treasury_id")
  //  @JsonBackReference

    //private Treasury treasury;
}
