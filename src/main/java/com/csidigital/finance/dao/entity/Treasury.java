package com.csidigital.finance.dao.entity;

import com.csidigital.finance.shared.enumeration.BankAccountType;
import com.csidigital.finance.shared.enumeration.CategoryCaisse;
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
    private String category ;
    private Long amount ;
    private Date date;
    private String description ;
    @Enumerated(EnumType.STRING)
    private CategoryCaisse categoryCaisse;







}
