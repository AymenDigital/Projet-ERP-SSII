package com.csidigital.finance.dao.entity;

import com.csidigital.finance.shared.enumeration.AdditionalFeeType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalFee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private Double cost;
    private Long tva;
    private Integer quantity;


    @Enumerated(EnumType.STRING)
    private AdditionalFeeType additionalFeeType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bill_id")
    @JsonBackReference

    private Bill bill;


}
