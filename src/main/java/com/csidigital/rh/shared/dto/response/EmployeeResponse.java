package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.Evaluation;
import com.csidigital.rh.dao.entity.OfferCandidate;
import com.csidigital.rh.dao.entity.TechnicalFile;
import com.csidigital.rh.shared.enumeration.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class EmployeeResponse {
    private Long Id;
    private String lastName;
    private String firstName;
    private Civility civility;
    private Title title;
    private EmployeeType employeeType;
    private LocalDate birthDate;
    private String emailOne;
    private String emailTwo;
    private Integer phoneNumberOne;
    private Integer phoneNumberTwo;
    private String address;
    private Integer postCode;
    private String city;
    private String country;

    private MaritalSituation maritalSituation;
    private Integer recommendationMark ;
    private Integer experience ;
    private String experienceDetails ;

    private EmployeeStatus employeeStatus;

    private WorkLocation workLocation;

    private Departement departement;

    private TechnicalFile technicalFile;

    private List<OfferCandidate> offerCandidateList;
    private Evaluation evaluation;

}