package com.csidigital.dao.entity;

import com.csidigital.shared.enumeration.Availability;
import com.csidigital.shared.enumeration.RequirementStatus;
import com.csidigital.shared.enumeration.RequirementType;
import com.csidigital.shared.enumeration.WorkField;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String title ;
    @Enumerated(EnumType.STRING)
    private RequirementType requirementType ;
    private String description ;
    private String Criteria ;
    @Enumerated(EnumType.STRING)
    private RequirementStatus requirementStatus ;
    @Enumerated(EnumType.STRING)
    private WorkField workField ;
    @Enumerated(EnumType.STRING)
    private Availability availability ;
    private Double plannedBudget ;

    private Double plannedIncome ;
    private LocalDate startDate ;
    private LocalDate expectedEndDate ;
    private LocalDate responseDate ;
    private  Integer totalCandidateNumber ;

    @ManyToOne
    private Partner partner;
}
