package com.csidigital.dao.entity;

import com.csidigital.shared.enumeration.BenefitStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private BenefitStatus benefitStatus ;
    private String titled ;
    private Double averageDailyCost ;
    private Double totalCost ;

    private Double cost ;
    private Double costEfficiency ;
    private Boolean exceptionalCosts;
    private Double monthlyFees ;

    @OneToMany(mappedBy = "benefit")
    private List<ExtraDuty> extraDuties;

    @OneToMany(mappedBy = "benefit")
    private List<WorkArrangement> workArrangements;



}
