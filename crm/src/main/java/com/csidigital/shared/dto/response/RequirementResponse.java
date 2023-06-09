package com.csidigital.shared.dto.response;

import com.csidigital.shared.enumeration.Availability;
import com.csidigital.shared.enumeration.RequirementStatus;
import com.csidigital.shared.enumeration.RequirementType;
import com.csidigital.shared.enumeration.WorkField;

import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.time.LocalDate;

@Data
@RequiredArgsConstructor

public class RequirementResponse {
    private Long id ;
    private String title ;
    private RequirementType requirementType ;
    private String description ;
    private String Criteria ;
    private RequirementStatus requirementStatus ;
    private WorkField workField ;
    private Availability availability ;
    private Double plannedBudget ;
    private Double plannedIncome ;
    private LocalDate startDate ;
    private LocalDate expectedEndDate ;
    private LocalDate responseDate ;

    private Integer totalCandidateNumber ;
    private String company;
    private Long partnerId ;


}
