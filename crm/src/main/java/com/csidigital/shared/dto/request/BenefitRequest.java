package com.csidigital.shared.dto.request;


import com.csidigital.dao.entity.ExtraDuty;
import com.csidigital.dao.entity.WorkArrangement;
import com.csidigital.shared.enumeration.BenefitStatus;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;


@Data

public class BenefitRequest {

    private BenefitStatus benefitStatus ;
    private String titled ;
    private double averageDailyCost ;
    private double totalCost ;

    private double cost ;
    private double costEfficiency ;
    private boolean exceptionalCosts;
    private double monthlyFees ;


    private List<ExtraDuty> extraDuties;


    private List<WorkArrangement> workArrangements;



}
