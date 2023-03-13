package com.csidigital.shared.dto.request;

import com.csidigital.dao.entity.Partner;
import com.csidigital.shared.enumeration.Availability;
import com.csidigital.shared.enumeration.RequirementStatus;
import com.csidigital.shared.enumeration.RequirementType;
import com.csidigital.shared.enumeration.WorkField;

import jakarta.persistence.ManyToOne;
import lombok.Data;


import java.time.LocalDate;
@Data

public class RequirementRequest {

    private String title ;
    private RequirementType requirementType ;
    private String description ;
    private String criteria ;
    private RequirementStatus requirementStatus ;
    private WorkField workField ;
    private Availability availability ;
    private Double plannedBudget ;
    private Double plannedIncome ;
    private LocalDate startDate ;
    private LocalDate expectedEndDate ;
    private LocalDate responseDate ;
    private  Integer totalCandidateNumber ;

    private Partner partner ;


}
