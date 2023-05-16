package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.shared.enumeration.Provenance;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CandidateRequest  {
    private Provenance provenance;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeSerialNumber;
    private Long AssOfferCandidateId;




}
