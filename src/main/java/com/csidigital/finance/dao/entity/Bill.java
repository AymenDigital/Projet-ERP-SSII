package com.csidigital.finance.dao.entity;

import com.csidigital.finance.shared.enumeration.Currency;
import com.csidigital.finance.shared.enumeration.CurrencyAdditionalFees;
import com.csidigital.finance.shared.enumeration.InvoiceStatus;
import com.csidigital.finance.shared.enumeration.InvoiceType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer invoiceNumber;

    private Date date;

    private String nameSeller;

    private String addressSeller;

    private String nameBuyer;

    private String addressBuyer;

    private Integer discount ;

    @Enumerated(EnumType.STRING)

    private InvoiceStatus InvoiceStatus;


    @Enumerated(EnumType.STRING)

    private Currency Currency;

    @OneToMany(mappedBy = "bill",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference

    private List<AdditionalFee> additionalFees;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference

    @JoinColumn(name = "treasury_id")

    private Treasury treasury;


}
