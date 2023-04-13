package com.csidigital.finance.dao.entity;

import com.csidigital.finance.shared.enumeration.BankAccountType;
import com.csidigital.finance.shared.enumeration.Currency;
import com.csidigital.finance.shared.enumeration.TreasuryType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Treasury implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private Double amount;
    private Date date;
    private Double total;
    @Enumerated(EnumType.STRING)
    private TreasuryType treasuryType;
    @Enumerated(EnumType.STRING)
    private BankAccountType bankAccountType;
    @Enumerated(EnumType.STRING)
    private Currency currency;


    @OneToMany(mappedBy = "treasury",fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Bill> bills;

    @OneToMany(mappedBy = "treasury",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference

    private List<Category> categories;

    @OneToMany(mappedBy = "treasury",fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<BankReconciliation> bankReconciliations;

}
